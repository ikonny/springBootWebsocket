package cn.hkfdt.xiaot.websocket.service.impl;

import cn.hkfdt.xiaot.common.XiaoTCommon;
import cn.hkfdt.xiaot.common.beans.ReqCommonBean;
import cn.hkfdt.xiaot.common.beans.RspCommonBean;
import cn.hkfdt.xiaot.mybatis.mapper.ltschina.TGameMapper;
import cn.hkfdt.xiaot.mybatis.mapper.ltschina.TGameUserExtendsMapper;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TGame;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TGameExample;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TGameUser;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TGameUserExample;
import cn.hkfdt.xiaot.web.xiaot.service.XiaoTService;
import cn.hkfdt.xiaot.websocket.Beans.GameRuntimeBean;
import cn.hkfdt.xiaot.websocket.Beans.GameUserExtBean;
import cn.hkfdt.xiaot.websocket.Beans.GameUserStateBean;
import cn.hkfdt.xiaot.websocket.service.GameService;
import cn.hkfdt.xiaot.websocket.topic.XiaoTMatchTopics;
import org.apache.commons.collections.map.LinkedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static cn.hkfdt.xiaot.websocket.service.impl.MatchServiceHelper.cacheMapXM;

@Service
public class GameServiceImpl implements GameService {

	static Logger logger = LoggerFactory.getLogger(GameServiceImpl.class);

	@Autowired
	XiaoTMatchTopics xiaoTMatchTopics;
	@Autowired
	XiaoTService xiaoTService;
	@Autowired
	TGameMapper tGameMapper;
	@Autowired
	TGameUserExtendsMapper tGameUserExtendsMapper;
	@Autowired
	GameService gameService;
	//==================================================================
	@PostConstruct
	public void init(){
		MatchServiceHelper.gameService = gameService;
	}

	@Override
	public RspCommonBean getUserState(ReqCommonBean reqCommonBean) {
		RspCommonBean rspCommonBean = RspCommonBean.getCommonRspBean(200,null);

		GameUserStateBean gameUserStateBean = new GameUserStateBean();
		rspCommonBean.data = gameUserStateBean;

		String userId = reqCommonBean.fdtId;
		String gameId = reqCommonBean.data.get("gameId").toString();
		TGame tGame = getTgame(gameId);
		GameRuntimeBean gameRuntimeBean = (GameRuntimeBean) cacheMapXM.get(gameId);

		if(tGame==null){
			//比赛不存在
			rspCommonBean.msg = "比赛不存在";
			rspCommonBean.rspCode = 201;
			return rspCommonBean;
		}
		//比赛存在，看是否是参加了比赛
		TGameUser tGameUser = getGameUser(gameId,userId);
		if(gameRuntimeBean==null || gameRuntimeBean.state==2){
			//比赛已经结束,跳静态页面
			gameUserStateBean.curState = 4;
			rspCommonBean.rspCode = 200;
			return rspCommonBean;
		}else{
			//比赛未结束，还在内存中
			if(gameRuntimeBean.notStart()){
				//没有开始
				gameUserStateBean.curState = 1;
			}else{
				if(gameRuntimeBean.canReConnect(userId)){
					gameUserStateBean.curState = 2;
					gameRuntimeBean.reJoinUser(userId);
				}else{
					//跳动态排行榜
					gameUserStateBean.curState = 3;
					gameUserStateBean.tag = gameRuntimeBean.listRank;
				}
			}
			//-----------------------------------
			GameUserExtBean gameUserExtBean = gameRuntimeBean.mapUsers.get(userId);
			gameUserStateBean.gameName = tGame.getGameName();
			gameUserStateBean.userNum = gameRuntimeBean.userNum;
			gameUserStateBean.curUserNum = gameRuntimeBean.mapUsers.size();
			if(gameUserExtBean!=null){
				gameUserStateBean.actions = gameUserExtBean.actions;
				gameUserStateBean.userName = gameUserExtBean.userName;
				gameUserStateBean.headimgurl = gameUserExtBean.headimgurl;
//				gameUserStateBean.userType = gameUserExtBean.userType;
			}
		}

		return rspCommonBean;
	}

	@Override
	public int ready(ReqCommonBean reqCommonBean) {
		final String gameId = reqCommonBean.data.get("gameId").toString();
		int flag;
		synchronized(gameId){
			flag = MatchServiceHelper.ready(reqCommonBean);
		}
		return flag;
	}
	@Override
	public RspCommonBean userUnReady(ReqCommonBean reqCommonBean) {
		RspCommonBean rspCommonBean = RspCommonBean.getCommonRspBean(200,null);
		String gameId = reqCommonBean.data.get("gameId").toString();
		String fdtId = reqCommonBean.fdtId;
		GameRuntimeBean gameRuntimeBean = (GameRuntimeBean) cacheMapXM.get(gameId);
		if(gameRuntimeBean==null){
			rspCommonBean.rspCode = 201;
			rspCommonBean.msg = "比赛不存在";
			return rspCommonBean;
		}
		synchronized (gameRuntimeBean){
			if(gameRuntimeBean.notStart()){
				//比赛还没开始，尝试取消准备
				int flag = gameRuntimeBean.unReadyUser(fdtId);
				if(flag==1){
					return rspCommonBean;
				}
			}else{
				rspCommonBean.rspCode = 202;
				rspCommonBean.msg = "比赛已经开始";
				return rspCommonBean;
			}
		}
		return rspCommonBean;
	}
	@Override
	public int gameStart(ReqCommonBean reqCommonBean) {
		//{"action":"go","gameId":"adsffgcsdf"}
		String gameId = reqCommonBean.data.get("gameId").toString();
		//画线间隔
		int drawTimer = Integer.parseInt(reqCommonBean.data.get("drawTimer").toString());
		GameRuntimeBean gameRuntimeBean = (GameRuntimeBean) cacheMapXM.get(gameId);
		if(gameRuntimeBean==null){
			return -2;
		}
		if(!gameRuntimeBean.isGameCanGo()){
			//一个人也没有
			return -1;
		}
		//---------------------------------------
//		以下设置比赛开始逻辑
		synchronized (gameRuntimeBean){
			//不能多次按比赛开始
			if(gameRuntimeBean.notStart()){
				gameRuntimeBean.startSet();
			}else{
				return 0;
			}
		}
		gameRuntimeBean.userNum = gameRuntimeBean.mapUsers.size();//修改比赛开始人数
		cacheMapXM.put(gameId,gameRuntimeBean,gameRuntimeBean.getGameTime());//开始后调整时间
		//-------------------------------------------
		//更新比赛状态
		XiaoTCommon.executorService.submit(()->{
			//这里面比较耗时间，特别是人多后200+，为了不影响及时响应开始，异步入库
			updateGameAndInsertUserWithStart(gameRuntimeBean);//执行失败就报错，就不会通知开始
		});
		//-----------------------------------------------
		xiaoTMatchTopics.start(gameId);//通知各端比赛开始
		//比赛计时，通知开始
		if(drawTimer<=500){
			drawTimer = 500;
		}
		gameRuntimeBean.start(xiaoTMatchTopics,drawTimer);
		return 0;
	}

	/**
	 * 比赛开始时更新比赛状态，插入本次比赛选手
	 * @param gameRuntimeBean
	 * @return
	 */
	private int updateGameAndInsertUserWithStart(GameRuntimeBean gameRuntimeBean) {
		gameRuntimeBean.tGame.setState(1);
		updateGameSelect(gameRuntimeBean.tGame);

		long time = System.currentTimeMillis();
		gameRuntimeBean.mapUsers.values().forEach(item->{
			TGameUser tGameUser = MatchServiceHelper.getGameUser(item, gameRuntimeBean, 1);
			tGameUser.setCreateTime(time);
			tGameUserExtendsMapper.insert(tGameUser);
		});
		return 1;
	}

	@Override
	public int gameEnd(ReqCommonBean reqCommonBean) {
		//{  gameId: '', userId: '}
		String gameId = reqCommonBean.data.get("gameId").toString();
		String userId = reqCommonBean.data.get("userId").toString();
		//1:比赛进行中确认退出   3：比赛结束退出
		int userState = Integer.parseInt(reqCommonBean.data.get("state").toString());
		Map<String,Object>  mapRt = new LinkedMap(2);
		int flag = MatchServiceHelper.gameUserEnd(gameId,userId,userState);
		if(flag==0){
			GameRuntimeBean gameRuntimeBean = (GameRuntimeBean) cacheMapXM.get(gameId);
			GameUserExtBean item = gameRuntimeBean.mapUsers.get(userId);
			TGameUser tGameUser = MatchServiceHelper.getGameUser(item,gameRuntimeBean,2);
			//主动结束的选手记录到数据库
			gameUserUpdate(tGameUser);
		}
		if(flag==1){
			//该用户结束后，比赛结束
			GameRuntimeBean gameRuntimeBean = (GameRuntimeBean) cacheMapXM.get(gameId);
			cacheMapXM.remove(gameId);//删除这个key
			gameService.endTheGame(gameRuntimeBean);
		}
		return flag;
	}

	@Override
	public int endTheGame(GameRuntimeBean gameRuntimeBean) {

		synchronized (gameRuntimeBean) {
			if (!gameRuntimeBean.canUpdateDate()) {
				logger.info("!!!尝试更新已经更新过的比赛数据");
				return 0;
			}
			gameRuntimeBean.hasUpdateDb();
		}
		TGame tGame = gameRuntimeBean.tGame;
		long time = System.currentTimeMillis();
		tGame.setUpdateTime(time);
		tGame.setState(2);
		gameRuntimeBean.state = 2;

		logger.info("比赛结束："+tGame.getGameName());
		//
		List<GameUserExtBean> list = new ArrayList<>(gameRuntimeBean.userNum);
		gameRuntimeBean.mapUsers.values().forEach(item->{
			list.add(item.deepCopy());
		});
		Collections.sort(list, (item1, item2) -> {
			return -Double.compare(item1.returnRate,item2.returnRate);//item1.returnRate > item2.returnRate ? -1 : 1;
		});
		for(int i=0;i<list.size();i++){
			GameUserExtBean item = list.get(i);
			TGameUser tGameUser = MatchServiceHelper.getGameUser(item,gameRuntimeBean,2);
			tGameUser.setRanking(i+1);

			gameUserUpdate(tGameUser);
		}

		updateGameSelect(tGame);
		//比赛结束时，再次排序通知各订阅者
		MatchServiceHelper.sendTopicClientInfoAll(list,gameRuntimeBean.gameId);

		XiaoTCommon.executorService.submit(()->{
			//整场比赛，2秒后停止
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			xiaoTMatchTopics.gameEndTopic(gameRuntimeBean);
		});
		return 0;
	}

	@Override
	public void sendClientMatchInfo(ReqCommonBean reqCommonBean) {
		MatchServiceHelper.sendClientMatchInfo(reqCommonBean);
	}

	//==========================================================================
	private int gameUserUpdate(TGameUser tGameUser) {
		TGameUserExample tGameUserExample = new TGameUserExample();
		tGameUserExample.createCriteria().andGameIdEqualTo(tGameUser.getGameId())
				.andUserIdEqualTo(tGameUser.getUserId());
		return tGameUserExtendsMapper.updateByExampleSelective(tGameUser,tGameUserExample);
	}
	private int updateGameSelect(TGame tGame) {
		TGameExample tGameExample = new TGameExample();
		tGameExample.createCriteria().andGameIdEqualTo(tGame.getGameId());
		return tGameMapper.updateByExampleSelective(tGame,tGameExample);
	}
	private TGame getTgame(String gameId) {
		TGameExample tGameExample = new TGameExample();
		tGameExample.createCriteria().andGameIdEqualTo(gameId);
		List<TGame>  listGame = tGameMapper.selectByExample(tGameExample);
		if(listGame==null || listGame.isEmpty()){
			return null;
		}else{
			return listGame.get(0);
		}
	}
	private TGameUser getGameUser(String gameId, String userI) {
		TGameUserExample tGameUserExample = new TGameUserExample();
		tGameUserExample.createCriteria().andGameIdEqualTo(gameId)
				.andUserIdEqualTo(userI);
		List<TGameUser>  listUser = tGameUserExtendsMapper.selectByExample(tGameUserExample);
		if(listUser==null || listUser.isEmpty())
			return null;
		return listUser.get(0);
	}


}
