package cn.hkfdt.xiaot.web.xiaot.service.impl;

import cn.hkfdt.xiaot.common.XiaoTCommon;
import cn.hkfdt.xiaot.common.beans.GameCacheBean;
import cn.hkfdt.xiaot.mybatis.mapper.ltschina.TGameMapper;
import cn.hkfdt.xiaot.mybatis.model.ltschina.Auth;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TGame;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TQuestions;
import cn.hkfdt.xiaot.util.ImageUtil;
import cn.hkfdt.xiaot.util.MapUtil;
import cn.hkfdt.xiaot.web.Filters.LoginFilter;
import cn.hkfdt.xiaot.web.common.redis.RedisClient;
import cn.hkfdt.xiaot.web.common.service.AuthService;
import cn.hkfdt.xiaot.web.xiaot.service.XiaoTGameService;
import cn.hkfdt.xiaot.web.xiaot.service.XiaoTService;
import cn.hkfdt.xiaot.web.xiaot.util.XiaoTUserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
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


	//=================================================
	@Override
	public Map<String, Object> getGameUser(String fdtId) {
		Map<String, Object>  mapTar = new HashMap<>(3);
		if(LoginFilter.isNotLogin(fdtId)){
			fdtId = XiaoTHelp.xiaoTGuest;
			mapTar.put("userName","游客");
			mapTar.put("userId",fdtId);
			mapTar.put("userType",XiaoTUserType.OtherUser.getType());
		}else{
			Auth auth = authService.getAuthByFdtId(fdtId);
			mapTar.put("userName",auth.getUsername());
			mapTar.put("userId",fdtId);
			mapTar.put("userType", XiaoTUserType.FdtUser.getType());
			String headimgurl = ImageUtil.transAndResizeImg(auth.getServingUrl(),100,100);
			mapTar.put("headimgurl",headimgurl);
		}
		return mapTar;
	}

	@Override
	public Map<String, Object> gameCreate(Map<String, Object> mapPara) {

		String gameId = UUID.randomUUID().toString();
		Future future = createGameAsy(mapPara,gameId,true);
		Map<String, Object> resultMap = XiaoTGameHelp.genQRinfo(mapPara,gameId);
		if(!resultMap.containsKey("errorCode")){
			//生成二维码成功
			try {
				if(future.get() == null){
                    resultMap = MapUtil.getErrorMap(202,"数据库操作失败");
                }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultMap;
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
				mapTar = new HashMap<>(8);
				TQuestions tQuestions = xiaoTService.xiaotTraining(XiaoTHelp.xiaoTGuest, marketType, mapTar, "all");
				//创建比赛相关数据
				TGame tGame = new TGame();
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
						//设置6分钟超时
						RedisClient.setex(gameId, cacheBean, 60 * 6);
					}
				}
			}catch (Exception e){
				mapTar = null;
			}

			return mapTar;
		});
		return tar;
	}
}
