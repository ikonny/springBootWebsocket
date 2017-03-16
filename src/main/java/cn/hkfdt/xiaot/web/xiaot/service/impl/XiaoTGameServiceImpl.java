package cn.hkfdt.xiaot.web.xiaot.service.impl;

import cn.hkfdt.xiaot.common.XiaoTCommon;
import cn.hkfdt.xiaot.common.beans.GameCacheBean;
import cn.hkfdt.xiaot.common.beans.RspCommonBean;
import cn.hkfdt.xiaot.mybatis.mapper.ltschina.TGameExtendsMapper;
import cn.hkfdt.xiaot.mybatis.mapper.ltschina.TGameMapper;
import cn.hkfdt.xiaot.mybatis.mapper.ltschina.TGameUserExtendsMapper;
import cn.hkfdt.xiaot.mybatis.mapper.ltschina.TQuestionsExtendsMapper;
import cn.hkfdt.xiaot.mybatis.model.ltschina.Auth;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TGame;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TGameUser;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TQuestions;
import cn.hkfdt.xiaot.util.CookieUtil;
import cn.hkfdt.xiaot.util.ImageUtil;
import cn.hkfdt.xiaot.web.Filters.LoginFilter;
import cn.hkfdt.xiaot.web.common.globalinit.GlobalInfo;
import cn.hkfdt.xiaot.web.common.redis.RedisClient;
import cn.hkfdt.xiaot.web.common.service.AuthService;
import cn.hkfdt.xiaot.web.xiaot.service.XiaoTGameService;
import cn.hkfdt.xiaot.web.xiaot.service.XiaoTService;
import cn.hkfdt.xiaot.web.xiaot.service.md.XiaoTMDHelp;
import cn.hkfdt.xiaot.web.xiaot.util.XiaoTMarketType;
import cn.hkfdt.xiaot.web.xiaot.util.XiaoTUserType;
import cn.hkfdt.xiaot.web.xiaot.util.YSUtils;
import cn.hkfdt.xiaot.websocket.service.impl.MatchServiceHelper;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.Future;

/**
 * author:xumin 
 * 2016-12-15 下午4:12:42
 */
@Service
public class XiaoTGameServiceImpl implements XiaoTGameService {


	@Autowired
	AuthService authService;
	@Autowired
	TGameMapper tGameMapper;
	@Autowired
	XiaoTService xiaoTService;
	@Autowired
	TGameExtendsMapper tGameExtendsMapper;
	@Autowired
	TQuestionsExtendsMapper tQuestionsExtendsMapper;
	@Autowired
	TGameUserExtendsMapper tGameUserExtendsMapper;

	Gson gson = new Gson();

	private static final String GUEST_COOKIE_KEY = "fdt_xiaot_guest_info";

	//=================================================
	@Override
	public Map<String, Object> getGameUser(String fdtId, String gameId, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object>  mapTar = new HashMap<>(3);
		if(LoginFilter.isNotLogin(fdtId)){
			//游客先获取cookie
			String guestJson = CookieUtil.getCookie(GUEST_COOKIE_KEY, request);
			if (guestJson != null && !"".equals(guestJson)) {
				try {
					mapTar = gson.fromJson(URLDecoder.decode(guestJson, "utf-8"), new TypeToken<Map<String, Object>>() {
					}.getType());
				}catch (Exception e){
					e.printStackTrace();
				}
			}else {//没有cookie，生成用户信息，放入cookie
				fdtId = "g-" + XiaoTMDHelp.getRandomString(20);
				mapTar.put("userName", "游客");
				mapTar.put("userId", fdtId);
				mapTar.put("userType", XiaoTUserType.OtherUser.getType());
				mapTar.put("headimgurl", XiaoTMDHelp.getGuestAvator());
				try {
					CookieUtil.setCookie(response, Integer.MAX_VALUE, GlobalInfo.serverDomain, "/", GUEST_COOKIE_KEY, URLEncoder.encode(gson.toJson(mapTar), "utf-8"));
				}catch (Exception e){
					e.printStackTrace();
				}
			}



		}else{
			Auth auth = authService.getAuthByFdtId(fdtId);
			mapTar.put("userName",auth.getUsername());
			mapTar.put("userId",fdtId);
			mapTar.put("userType", XiaoTUserType.FdtUser.getType());
			String headimgurl = ImageUtil.transAndResizeImg(auth.getServingUrl(),100,100);
			mapTar.put("headimgurl",headimgurl);
		}
		mapTar.put("gameId", gameId);
		return mapTar;
	}

	@Override
	public RspCommonBean gameCreate(Map<String, Object> mapPara) {
		RspCommonBean rcb = new RspCommonBean();
		String gameId = UUID.randomUUID().toString();
		Future future = createGameAsy(mapPara,gameId,true);
		Map<String, Object> resultMap = XiaoTGameHelp.genQRinfo(mapPara,gameId);
		if(!resultMap.containsKey("errorCode")){
			//生成二维码成功
			try {
				if(future.get() == null){
                    rcb.msg = "数据库操作失败！";
					rcb.rspCode = 202;
                }else{
					rcb.rspCode = 200;
					rcb.data = resultMap;
				}
			} catch (Exception e) {
				rcb.msg = "系统异常";
				rcb.rspCode = 203;
			}
		}else{
			rcb.msg = "二维码生成出错";
			rcb.rspCode = 201;
		}
		return rcb;
	}

	/**
	 *获取某市场的随机比赛，插入比赛库，还可以入redis.
	 * 并且异步返回
	 * @param mapPara {"userNum":10,"gameName":"aa对抗赛","marketType":0}
	 * @param gameId
	 * @param isRedisIn  true 的话，就以gameId为key,将比赛信息插入redis
	 * @return 1插入比赛成功   其他失败
	 */
	public Future createGameAsy(Map<String, Object> mapPara, String gameId,boolean isRedisIn) {
		Future tar = XiaoTCommon.executorService.submit(()->{
			Map<String, Object> mapTar = null;
			try {
				int marketType = Integer.parseInt(mapPara.get("marketType").toString());
				String mkt = "FC";
				if(marketType == XiaoTMarketType.FC.getType()){
					mkt = XiaoTMarketType.FC.getCode();
				}else if(marketType == XiaoTMarketType.FX.getType()){
					mkt = XiaoTMarketType.FX.getCode();
				}else if(marketType == XiaoTMarketType.SC.getType()){
					mkt = XiaoTMarketType.SC.getCode();
				}
				mapTar = new HashMap<>(8);
				TQuestions tQuestions = xiaoTService.xiaotTraining(XiaoTHelp.xiaoTGuest, mkt, mapTar, "all");
				//创建比赛相关数据
				TGame tGame = new TGame();
				tGame.setState(0);
				tGame.setGameId(gameId);
				if (mapPara.containsKey("gameName")) {
					tGame.setGameName(mapPara.get("gameName").toString());
				}
				if (mapPara.containsKey("userNum")) {
					tGame.setUserNum(Integer.parseInt(mapPara.get("userNum").toString()));
				}
				tGame.setMarketType(marketType);
				long time = System.currentTimeMillis();
				tGame.setCreateTime(time);
				tGame.setUpdateTime(time);
				tGame.setQuestionId(tQuestions.getQuestionId());//主键

				if (tGameMapper.insert(tGame) != 1) {
					mapTar = null;
				}else{
					//操作成功
					if(isRedisIn) {
						GameCacheBean cacheBean = new GameCacheBean();
						cacheBean.mapTar = mapTar;
						tQuestions.setJsonData(null);
						cacheBean.tQuestions = tQuestions;
						cacheBean.tGame = tGame;
						//设置30分钟超时
						MatchServiceHelper.createGameAsy(cacheBean);
						RedisClient.setex(gameId, cacheBean, 60 * GlobalInfo.gameOvertimeM);
					}
				}
			}catch (Exception e){
				e.printStackTrace();
				mapTar = null;
			}

			return mapTar;
		});
		return tar;
	}


	@Override
	public int getGameStatus(String gameId) {
		TGame tg = tGameExtendsMapper.selectGameByGameId(gameId);
		if(tg.getState() == null){
			tg.setState(0);
		}
		return tg.getState();
	}

	@Override
	public RspCommonBean getGameInfo(String gameId, String type) {
		RspCommonBean rcb = new RspCommonBean();
		TGame tg = tGameExtendsMapper.selectGameByGameId(gameId);
		int questionId = tg.getQuestionId();
		TQuestions tq = tQuestionsExtendsMapper.selectByPrimaryKey(questionId);
		byte[] jsonData = tq.getJsonData();
		Map<String, Object> mapTar = new HashMap<>();
		try {
			//获取解压后的真实数据json
			jsonData = YSUtils.uncompress(jsonData);
			Map<String, Object> jsonDataMap = new HashMap<String, Object>(6);
			jsonDataMap = JSON.parseObject(new String(jsonData));//(Map<String, Object>) JsonUtil.JsonToOb(new String(jsonData), jsonDataMap.getClass());
			List<Map<String, Object>> hiList = (List<Map<String,Object>>) (((Map<String,Object>)jsonDataMap.get("history")).get("items"));
			Collections.reverse(hiList);

			Map<String, Object> hMap = (Map<String,Object>)jsonDataMap.get("history");
			List<Map<String, Object>> needHistoryList = new ArrayList<>();
			int index = 0;
			for (Map<String, Object> som : hiList) {
				needHistoryList.add(0, som);
				index++;
				if(index >= 40){
					break;
				}
			}
			hMap.put("items", needHistoryList);
			jsonDataMap.put("history", hMap);
			if("today".equalsIgnoreCase(type)){
				jsonDataMap.put("history", null);
			}else if("history".equalsIgnoreCase(type)){
				jsonDataMap.put("today", null);
			}
			mapTar.put("jsonData",jsonDataMap );

			mapTar.put("key", XiaoTHelp.getTKey(tq));
			mapTar.put("market", XiaoTHelp.getMarketCode(tq));

			String tradeTime = tq.getTradeDay();
			mapTar.put("tradeTime", tradeTime.replace("-", "."));
			rcb.rspCode = 200;
			rcb.data = mapTar;

		} catch (IOException e) {
			e.printStackTrace();
			rcb.rspCode = 201;
			rcb.msg = "获取比赛信息出错！";
		}
		return rcb;
	}

	@Override
	public RspCommonBean getGameResult(String gameId) {
		RspCommonBean rcb = new RspCommonBean();
		List<TGameUser> tguList = tGameUserExtendsMapper.selectGameUserByGameId(gameId);
		List<Map<String,Object>> userInfoList = new ArrayList<>();
		if(tguList != null){
			for (TGameUser tgu : tguList) {
				Map<String, Object> resultMap = new HashMap<>();
				resultMap.put("rankIdx", tgu.getRanking());
				resultMap.put("curIdx", tgu.getCurIdx());
				resultMap.put("userName", tgu.getNickName());
				resultMap.put("userId", tgu.getUserId());
				resultMap.put("returnRate", tgu.getReturnRate());
				String action = tgu.getActions();
				String keyWord = "side";
				int orgLength = action.length();
				int cutLength = action.replace(keyWord, "").length();
				int count = (orgLength - cutLength) / keyWord.length();
				resultMap.put("count", count);
				resultMap.put("headimgurl", tgu.getHeadimgurl());
				resultMap.put("actions", tgu.getActions() != null ? tgu.getActions() : new ArrayList<>());
				userInfoList.add(resultMap);
			}
		}
		rcb.rspCode = 200;
		rcb.data = userInfoList;
		return rcb;
	}
}
