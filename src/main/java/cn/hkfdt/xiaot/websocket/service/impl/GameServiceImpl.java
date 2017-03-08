package cn.hkfdt.xiaot.websocket.service.impl;

import cn.hkfdt.xiaot.common.beans.ReqCommonBean;
import cn.hkfdt.xiaot.mybatis.mapper.ltschina.TGameMapper;
import cn.hkfdt.xiaot.mybatis.mapper.ltschina.TGameUserExtendsMapper;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TGame;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TGameExample;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TGameUser;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TGameUserExample;
import cn.hkfdt.xiaot.web.xiaot.service.XiaoTService;
import cn.hkfdt.xiaot.websocket.Beans.GameRuntimeBean;
import cn.hkfdt.xiaot.websocket.Beans.GameUserExtBean;
import cn.hkfdt.xiaot.websocket.service.GameService;
import cn.hkfdt.xiaot.websocket.topic.XiaoTMatchTopics;
import org.apache.commons.collections.map.LinkedMap;
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
	public int ready(ReqCommonBean reqCommonBean) {
		final String gameId = reqCommonBean.data.get("gameId").toString();
		int flag;
		synchronized(gameId){
			flag = MatchServiceHelper.ready(reqCommonBean);
		}
		if(flag>=0) {
			//准备成功才通知
			xiaoTMatchTopics.readyInfo(gameId);
		}
		return flag;
	}
	@Override
	public int gameStart(ReqCommonBean reqCommonBean) {
		//{"action":"go","gameId":"adsffgcsdf"}
		String gameId = reqCommonBean.data.get("gameId").toString();
		int stayTime = Integer.parseInt(reqCommonBean.data.get("stayTime").toString());
		GameRuntimeBean gameRuntimeBean = (GameRuntimeBean) cacheMapXM.get(gameId);
		if(gameRuntimeBean==null){
			return -2;
		}
//		if(!gameRuntimeBean.isUserAllReady()){
//			return -1;
//		}
		gameRuntimeBean.userNum = gameRuntimeBean.mapUsers.size();//修改比赛开始人数
		cacheMapXM.put(gameId,gameRuntimeBean,stayTime+50);//开始后调整时间
		xiaoTMatchTopics.start(gameId);//通知各端比赛开始
		//比赛计时，通知开始
		gameRuntimeBean.start(xiaoTMatchTopics);
		//更新比赛状态
		gameRuntimeBean.tGame.setState(1);
		gameInsertOrUpdate(gameRuntimeBean.tGame);
		return 0;
	}

	@Override
	public int gameEnd(ReqCommonBean reqCommonBean) {
		//{  gameId: '', userId: '}
		String gameId = reqCommonBean.data.get("gameId").toString();
		String userId = reqCommonBean.data.get("userId").toString();
		Map<String,Object>  mapRt = new LinkedMap(2);
		int flag = MatchServiceHelper.gameUserEnd(gameId,userId);
		if(flag==0){
			GameRuntimeBean gameRuntimeBean = (GameRuntimeBean) cacheMapXM.get(gameId);
			//主动结束的选手记录到数据库
			gameService.gameUserInsertOrUpdate(gameRuntimeBean,userId);
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
		TGame tGame = gameRuntimeBean.tGame;
		long time = System.currentTimeMillis();
		tGame.setUpdateTime(time);
		tGame.setState(2);

		//
		List<GameUserExtBean> list = new ArrayList<>(gameRuntimeBean.userNum);
		gameRuntimeBean.mapUsers.values().forEach(item->{
			list.add(item);
		});
		Collections.sort(list, (item1, item2) -> {
			return item1.returnRate > item2.returnRate ? -1 : 1;
		});
		for(int i=0;i<list.size();i++){
			GameUserExtBean item = list.get(i);
			TGameUser tGameUser = MatchServiceHelper.getGameUser(item,gameRuntimeBean,2);
			tGameUser.setRanking(i+1);

			gameUserInsertOrUpdate(tGameUser);
		}

		gameInsertOrUpdate(tGame);
		//比赛结束时，再次排序通知各订阅者
		MatchServiceHelper.sendTopicClientInfoAll(list,gameRuntimeBean.gameId);
		xiaoTMatchTopics.gameEndTopic(gameRuntimeBean.gameId);
		return 0;
	}

	@Override
	public int gameUserInsertOrUpdate(GameRuntimeBean gameRuntimeBean, String userId) {
		GameUserExtBean item = gameRuntimeBean.mapUsers.get(userId);
		TGameUser tGameUser = MatchServiceHelper.getGameUser(item,gameRuntimeBean,2);
		return gameUserInsertOrUpdate(tGameUser);
	}

	private int gameUserInsertOrUpdate(TGameUser tGameUser) {
		TGameUserExample tGameUserExample = new TGameUserExample();
		tGameUserExample.createCriteria().andGameIdEqualTo(tGameUser.getGameId())
				.andUserIdEqualTo(tGameUser.getUserId());
		List<TGameUser> listGameUser = tGameUserExtendsMapper.selectByExample(tGameUserExample);
		if(listGameUser.isEmpty()){
			tGameUser.setCreateTime(tGameUser.getUpdateTime());
			return tGameUserExtendsMapper.insert(tGameUser);
		}else{
			tGameUser.setId(listGameUser.get(0).getId());
			return tGameUserExtendsMapper.updateByPrimaryKey(tGameUser);
		}
	}

	private int gameInsertOrUpdate(TGame tGame) {
		TGameExample tGameExample = new TGameExample();
		tGameExample.createCriteria().andGameIdEqualTo(tGame.getGameId());
		List<TGame> listGame = tGameMapper.selectByExample(tGameExample);
		if(listGame.isEmpty()){
			return tGameMapper.insert(tGame);
		}else{
			tGame.setId(listGame.get(0).getId());
			return tGameMapper.updateByPrimaryKey(tGame);
		}
	}

	@Override
	public void sendClientMatchInfo(ReqCommonBean reqCommonBean) {
		MatchServiceHelper.sendClientMatchInfo(reqCommonBean);
	}



}
