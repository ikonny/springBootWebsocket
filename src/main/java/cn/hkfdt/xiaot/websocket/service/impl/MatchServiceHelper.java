package cn.hkfdt.xiaot.websocket.service.impl;

import cn.hkfdt.xiaot.common.CacheMapXM;
import cn.hkfdt.xiaot.common.beans.GameCacheBean;
import cn.hkfdt.xiaot.common.beans.ReqCommonBean;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TGameUser;
import cn.hkfdt.xiaot.util.EmojiUtil;
import cn.hkfdt.xiaot.web.common.LogUtil;
import cn.hkfdt.xiaot.web.common.globalinit.GlobalInfo;
import cn.hkfdt.xiaot.websocket.Beans.GameRuntimeBean;
import cn.hkfdt.xiaot.websocket.Beans.GameUserExtBean;
import cn.hkfdt.xiaot.websocket.service.GameService;
import cn.hkfdt.xiaot.websocket.topic.XiaoTMatchTopics;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MatchServiceHelper {
	/**
	 * 主要的比赛对象，需要定时回收matchId 为key 
	 * matchJson,num,matchPeople(map),createTime,readyTime,rankList(最新的排序成绩)
	 * matchPeople : fdtId为key : {curIdx, yieldRate, tradeCount, drawOption, fdtId,nickName}
	 * rankList : listMap 对matchPeople 中的排序
	 */
	public static CacheMapXM cacheMapXM = new CacheMapXM();
	public static XiaoTMatchTopics xiaoTMatchTopics = null;//被动注入的
	public static GameService gameService = null;
	private static Logger logger = LoggerFactory.getLogger(MatchServiceHelper.class);
	/**
	 * @param args
	 * author:xumin 
	 * 2017-1-11 上午10:09:53
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static{
		Runnable runnable = new Runnable() {

			public void run() {
				try {
					cacheMapXM.mapMatchInfo.forEachKey(2,key->{
						GameRuntimeBean gameRuntimeBean = (GameRuntimeBean) cacheMapXM.get(key);
						if (gameRuntimeBean.clientVersion != gameRuntimeBean.serverVersion) {
							//拷贝一份数据
							List<GameUserExtBean> list = new ArrayList<>(gameRuntimeBean.userNum);
							gameRuntimeBean.mapUsers.values().forEach(item -> {
								GameUserExtBean itemNew = item.deepCopy();
								list.add(itemNew);
							});
							//----------------------------------------------
							sendTopicClientInfoAll(list, gameRuntimeBean.gameId);
							gameRuntimeBean.serverVersion = gameRuntimeBean.clientVersion;
						}
					});
				}catch (Exception e){
					e.printStackTrace();
					LogUtil.logSensitive(e.getMessage());
				}
			}
		};
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		// 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间. 注意，万一出错，不捕捉异常是会停止的
		service.scheduleAtFixedRate(runnable, 10, 500, TimeUnit.MILLISECONDS);

		//==========指定超时回收事件处理=========================
		cacheMapXM.addListener((Object item,String key)->{
			GameRuntimeBean gameRuntimeBean = (GameRuntimeBean) item;
			logger.info(gameRuntimeBean.tGame.getGameName()+"__超时结束回收");
			gameService.endTheGame(gameRuntimeBean);
		});
	}

	/**
	 * 监听下发下来的断线通知
	 * @param fdtId
	 * @param sessionId
	 */
	public static void disConnectAndAfterRmove(String fdtId, String sessionId) {
		cacheMapXM.mapMatchInfo.forEachKey(2,key->{
			GameRuntimeBean gameRuntimeBean = (GameRuntimeBean) cacheMapXM.get(key);
			gameRuntimeBean.disConnectAndAfterRmove(fdtId,sessionId);
		});
	}
	//==============================================================================
	public static void createGameAsy(GameCacheBean cacheBean) {
		//比赛创建后5分钟后不开始，比赛超时，需要重新创建
		GameRuntimeBean gameRuntimeBean = new GameRuntimeBean();
		gameRuntimeBean.userNum = cacheBean.tGame.getUserNum();
		gameRuntimeBean.gameId = cacheBean.tGame.getGameId();
		gameRuntimeBean.mapUsers = new LinkedHashMap<>(gameRuntimeBean.userNum);
		gameRuntimeBean.mapUsersEnd = new HashMap<>(gameRuntimeBean.userNum);
		gameRuntimeBean.tGame = cacheBean.tGame;
		gameRuntimeBean.tQuestions = cacheBean.tQuestions;
//		gameRuntimeBean.listUser = new ArrayList<>(gameRuntimeBean.userNum);

		cacheMapXM.put(gameRuntimeBean.gameId,gameRuntimeBean,60* GlobalInfo.gameOvertimeM);
	}
	//==============================================================
	/**
	 * 
	 * @param reqCommonBean sessionId,matchId
	 * @return -2 比赛不存在，超时， -1比赛人数已满 ，0：准备成功 ,1:准备成功+可以通知开始
	 * -3 比赛已开始
	 * author:xumin 
	 * 2017-1-11 上午11:29:29
	 */
	@SuppressWarnings("unchecked")
	public static int ready(ReqCommonBean reqCommonBean) {
		String gameId = reqCommonBean.data.get("gameId").toString();
		GameRuntimeBean gameRuntimeBean = (GameRuntimeBean) cacheMapXM.get(gameId);
		if(gameRuntimeBean==null)
			return -2;
		if(!gameRuntimeBean.notStart()){
			return -3;
		}
		GameUserExtBean gameUserExtBean = getReadyUser(reqCommonBean);
		if(!gameRuntimeBean.canJoinGame(gameUserExtBean.userId)){
			return -1;
		}
		gameRuntimeBean.insertGameUser(gameUserExtBean);
		//准备成功才通知
		xiaoTMatchTopics.readyInfo(gameId);

		logger.info("比赛gameId:"+gameRuntimeBean.gameId+"_num:"+gameRuntimeBean.userNum
				+"__加入一人fdtId:"+gameUserExtBean.userId);
		return 0;
	}
	// {"userName":"小李","userType":2,"userId":"sagfcdgthgjk",
	// "headimgurl":"https://sdf.ico","gameId":"asfddhgh"}
	private static GameUserExtBean getReadyUser(ReqCommonBean reqCommonBean) {
		GameUserExtBean gameUserExtBean = new GameUserExtBean();
		gameUserExtBean.userId = reqCommonBean.data.get("userId").toString();
		gameUserExtBean.userName = reqCommonBean.data.get("userName").toString();
		gameUserExtBean.userType = Integer.parseInt(reqCommonBean.data.get("userType").toString());
		gameUserExtBean.headimgurl = reqCommonBean.data.get("headimgurl").toString();
		gameUserExtBean.gameId = reqCommonBean.data.get("gameId").toString();
		return gameUserExtBean;
	}

	/**
	 * 将客户端数据更新到服务端，用来之后的排序
	 * @param reqCommonBean
	 */
	public static void sendClientMatchInfo(ReqCommonBean reqCommonBean) {
		//{ curIdx: 1, gameId: '', userId: '',actions: [],returnRate: ''}
		Map<String,Object> mapPara = reqCommonBean.data;
		String gameId = mapPara.get("gameId").toString();
		String userId = mapPara.get("userId").toString();
		GameRuntimeBean gameRuntimeBean = (GameRuntimeBean)cacheMapXM.get(gameId);
		if(gameRuntimeBean==null){
			LogUtil.logSensitive("比赛结束了，还在发实时信息gameId:"+gameId+"   userId:"+userId);
			return ;
		}
		GameUserExtBean gameUserExtBean = gameRuntimeBean.mapUsers.get(userId);//获取到当前比赛用户信息
		if(gameUserExtBean==null){
			LogUtil.logSensitive("该用户不属于这个比赛！！_"+gameId+"   userId:"+userId);
			return ;
		}
		//更新数据
		gameUserExtBean.gameId = gameId;
		gameUserExtBean.curIdx = Integer.parseInt(mapPara.get("curIdx").toString());
		gameUserExtBean.returnRate = Double.parseDouble(mapPara.get("returnRate").toString());
		gameUserExtBean.actions = mapPara.get("actions");

		gameRuntimeBean.clientVersion++;
	}
	public static void sendTopicClientInfoAll(List<GameUserExtBean> list, String gameId) {
		Collections.sort(list, (item1, item2) -> {
			return -Double.compare(item1.returnRate,item2.returnRate);//item1.returnRate > item2.returnRate ? -1 : 1;
		});
		xiaoTMatchTopics.clientInfo(list,gameId);
		xiaoTMatchTopics.listInfo(list,gameId);
	}

	/**
	 * 0:带回gameUserExtBean -1：比赛早就结束 1：本次操作后比赛结束
	 * 返回用户信息，移除用户对象，如果最后一个用户结束，则游戏结束
	 *
	 * @param userState 1:比赛进行中确认退出   3：比赛结束退出
	 * @param gameId
	 * @param userId
	 * @return gameUserExtBean,gameRuntimeBean
	 */
	public static int gameUserEnd(String gameId, String userId,int userState) {
		GameRuntimeBean gameRuntimeBean = (GameRuntimeBean) cacheMapXM.get(gameId);
		if(gameRuntimeBean==null)
			return -1;
		int flag = gameRuntimeBean.gameUserEnd(userId,userState);
		return flag;
	}

	/**
	 *
	 * @param gameUserExtBean
	 * @param gameRuntimeBean
	 * @param state 0:创建  1:进行中  2:结束
	 * @return
	 */
	public static TGameUser getGameUser(GameUserExtBean gameUserExtBean, GameRuntimeBean gameRuntimeBean, int state) {
		long time = System.currentTimeMillis();
		TGameUser tGameUser = new TGameUser();
		tGameUser.setGameId(gameUserExtBean.gameId);
		tGameUser.setUserId(gameUserExtBean.userId);
		tGameUser.setUserType(gameUserExtBean.userType);
		String userName = EmojiUtil.filterEmoji(gameUserExtBean.userName);
		tGameUser.setNickName(userName);
		tGameUser.setHeadimgurl(gameUserExtBean.headimgurl);
		tGameUser.setUpdateTime(time);
		tGameUser.setState(state);
		tGameUser.setQuestionId(gameRuntimeBean.tQuestions.getQuestionId());
		tGameUser.setReturnRate(gameUserExtBean.returnRate);
		tGameUser.setMarketType(gameRuntimeBean.tGame.getMarketType());
		tGameUser.setActions( JSON.toJSONString(gameUserExtBean.actions));
//		tGameUser.setGameId(gameUserExtBean.gameId);
		tGameUser.setCurIdx(gameUserExtBean.curIdx);
		return tGameUser;
	}


}
