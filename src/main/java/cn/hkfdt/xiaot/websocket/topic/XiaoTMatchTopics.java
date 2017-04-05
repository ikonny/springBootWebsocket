package cn.hkfdt.xiaot.websocket.topic;

import cn.hkfdt.xiaot.common.beans.GameUserBean;
import cn.hkfdt.xiaot.common.beans.RspCommonBean;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TQuestionsNew;
import cn.hkfdt.xiaot.websocket.Beans.GameRuntimeBean;
import cn.hkfdt.xiaot.websocket.Beans.GameUserExtBean;
import cn.hkfdt.xiaot.websocket.Beans.GameUserListBean;
import cn.hkfdt.xiaot.websocket.common.ClientAgentMng;
import cn.hkfdt.xiaot.websocket.service.impl.MatchServiceHelper;
import cn.hkfdt.xiaot.websocket.utils.GameUrlHelp;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * 都是topic相关的订阅
 */
@Component
public class XiaoTMatchTopics {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	private static Logger logger = LoggerFactory.getLogger(XiaoTMatchTopics.class);
	public static String matchGo;
	static{
		Map<String, Object> map = new HashMap<>(2);
		map.put("rspCode", 200);
		map.put("data", "go");
		matchGo = JSON.toJSONString(map);
	}
	/**
	 * @param args
	 * author:xumin 
	 * 2017-1-10 下午4:57:16
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<GameUserExtBean> rankList = new ArrayList<>(2);
		GameUserExtBean item = new GameUserExtBean();
		item.returnRate = 2;
		item.gameId = "123";
		item.userType=1;
		item.userName="李雷";
		item.curIdx=1;
		item.headimgurl="https://df";
		item.userId="sf";
		rankList.add(item);

		item = new GameUserExtBean();
		item.returnRate = 1.2;
		item.gameId = "123";
		item.userType=1;
		item.userName="是否";
		item.curIdx=1;
		item.headimgurl="https://df";
		item.userId="sf";
		rankList.add(item);

		List<GameUserListBean> listTar = new ArrayList<>(rankList.size());
		rankList.forEach(itemT->{
			GameUserListBean itemTemp = new GameUserListBean();
			itemTemp.userId = itemT.userId;
//			itemTemp.headimgurl = itemT.headimgurl;
//			itemTemp.userName = itemT.userName;
//			itemTemp.userType = itemT.userType;
//			itemTemp.returnRate = itemT.returnRate;
			listTar.add(itemTemp);
		});
		RspCommonBean rspCommonBean = RspCommonBean.getCommonRspBean(200,null);
		rspCommonBean.data = listTar;
		String str = JSON.toJSONString(rspCommonBean);
//		System.out.println("send rankList: " + str);
		System.err.println(str);
	}
	//==================================================================== 
	@PostConstruct
	public void init(){
		MatchServiceHelper.xiaoTMatchTopics = this;
		ClientAgentMng.simpMessagingTemplate = simpMessagingTemplate;
	}

	/**
	 * 把准备列表推送到游戏相关订阅者
	 * /topic/game/readyInfo/gameId
	 * @param gameId
	 */
	public void readyInfo(String gameId) {
		String destination = GameUrlHelp.topic_userReadyInfo+gameId;
		GameRuntimeBean gameRuntimeBean = (GameRuntimeBean) MatchServiceHelper.cacheMapXM.get(gameId);
		if(gameRuntimeBean==null){
			RspCommonBean rspCommonBean = RspCommonBean.getCommonRspBean(201,"没有这个比赛");
			String str = JSON.toJSONString(rspCommonBean);
			simpMessagingTemplate.convertAndSend(destination, str);
			return ;
		}
		Map<String,Object> mapReady = new HashMap<>(3);
		List<GameUserBean> listUser = new ArrayList<>();
		Iterator<GameUserExtBean> iterable =  gameRuntimeBean.mapUsers.values().iterator();
		int index = 0;
		while(iterable.hasNext() && index<GameRuntimeBean.readyInfoSizeShow){
			++index;
			GameUserExtBean item = iterable.next();
			iterable.hasNext();
			GameUserBean itemNew = new GameUserBean();
			itemNew.userId = item.userId;
			itemNew.headimgurl = item.headimgurl;
			itemNew.userName = item.userName;
			itemNew.userType = item.userType;

			listUser.add(itemNew);
		}

		mapReady.put("totalSize",gameRuntimeBean.mapUsers.size());
		mapReady.put("list",listUser);

		RspCommonBean rspCommonBean = RspCommonBean.getCommonRspBean(200,null);
		rspCommonBean.data = mapReady;
		String str = JSON.toJSONString(rspCommonBean);

		simpMessagingTemplate.convertAndSend(destination, str);
	}
	/**
	 * 通知本次比赛参加人开始比赛
	 * @param gameId
	 * @return
	 * author:xumin
	 * 2017-1-10 下午5:23:07
	 */
	public void start(String gameId) {
		String destination = GameUrlHelp.topic_gameStart+gameId;
		simpMessagingTemplate.convertAndSend(destination, matchGo);
	}
	/**
	 * 排行榜计算完毕，并通知订阅此接口的用户.注意后面区分比赛id
	 * @param rankList
	 * @param gameId
	 * @return
	 * author:xumin 
	 * 2017-1-10 下午5:24:07
	 */
	public String listInfo(List<GameUserExtBean> rankList, String gameId) {
		String destination = GameUrlHelp.topic_gameListInfo+gameId;
		List<GameUserListBean> listTar = new ArrayList<>(rankList.size());
		List<String> listUserIdOrder = new ArrayList<>(rankList.size());//用于单纯的排序
		//有序的
		rankList.forEach(item->{
			GameUserListBean itemTemp = new GameUserListBean();
			itemTemp.userId = item.userId;
			itemTemp.headimgurl = item.headimgurl;
			itemTemp.userName = item.userName;
			itemTemp.userType = item.userType;
			itemTemp.returnRate = item.returnRate;
			try {
				String keyWord = "side";
				if(item.actions!=null) {
					String action = item.actions.toString();
					int orgLength = action.length();
					int cutLength = action.replace(keyWord, "").length();
					int count = (orgLength - cutLength) / keyWord.length();
					itemTemp.count = count;
				}
			}catch (Exception e){
				e.printStackTrace();
			}
			listTar.add(itemTemp);
			listUserIdOrder.add(itemTemp.userId);
		});
		//-------记录运行时排行榜------------
		GameRuntimeBean gameRuntimeBean = (GameRuntimeBean) MatchServiceHelper.cacheMapXM.get(gameId);
		if(gameRuntimeBean !=null){
			gameRuntimeBean.listRank = listTar;
		}
		//---------------------------------------------------------------------
		RspCommonBean rspCommonBean = RspCommonBean.getCommonRspBean(200,null);
		rspCommonBean.data = listTar;
		String str = JSON.toJSONString(rspCommonBean);
//		logger.info("send rankList: " + str);
		simpMessagingTemplate.convertAndSend(destination, str);
		listInfoSimple(listUserIdOrder,gameId);
		listInfoLimit(listTar,gameId);
		return str;
	}

	/**
	 * 比赛开始后，手机客户端参观比赛排行，使用的是限制50人的动态排行信息
	 * @param listTar 全量，已经排好序的列表进行截取
	 * @param gameId
	 */
	private void listInfoLimit(List<GameUserListBean> listTar, String gameId) {
		Map<String,Object> mapLimitListInfo = new HashMap<>(2);
		List<GameUserListBean> listLimitTar = new ArrayList<>(GameRuntimeBean.listInfoSizeShow);
		for(int i=0;i<GameRuntimeBean.listInfoSizeShow && i<listTar.size();i++){
			listLimitTar.add(listTar.get(i));
		}
		mapLimitListInfo.put("totalSize",listLimitTar.size());
		mapLimitListInfo.put("list",listLimitTar);

		RspCommonBean rspCommonBean = RspCommonBean.getCommonRspBean(200,null);
		rspCommonBean.data = mapLimitListInfo;
		String str = JSON.toJSONString(rspCommonBean);

		simpMessagingTemplate.convertAndSend("/topic/game/listInfoLimit/"+gameId, str);
	}

	/**
	 * 显示全部信息不过里面只有userId,用于客户端自己显示排名
	 * @param listUserIdOrder
	 * @param gameId
	 */
	private void listInfoSimple(List<String> listUserIdOrder, String gameId) {
		RspCommonBean rspCommonBean = RspCommonBean.getCommonRspBean(200,null);
		rspCommonBean.data = listUserIdOrder;
		String str = JSON.toJSONString(rspCommonBean);

		simpMessagingTemplate.convertAndSend("/topic/game/listInfoSimple/"+gameId, str);
	}

	/**
	 * 某比赛选手成绩更新后触发
	 * 透传给裁判页面打开的相关人
	 * 取前面15个人就行
	 * @param rankList
	 * @param gameId
	 * @return
	 * author:xumin 
	 * 2017-1-10 下午5:25:46
	 */
	public String clientInfo(List<GameUserExtBean> rankList, String gameId) {
		//这边只需要15个就行
		String destination = GameUrlHelp.topic_gameClientInfo+gameId;
		RspCommonBean rspCommonBean = RspCommonBean.getCommonRspBean(200,null);
		List<GameUserExtBean> tempList = new ArrayList<>(15);
		for(int i=0;i<15 && i<rankList.size();i++){
			tempList.add(rankList.get(i));
		}
		rspCommonBean.data = tempList;
		String str = JSON.toJSONString(rspCommonBean);
		simpMessagingTemplate.convertAndSend(destination, str);
		return str;
	}

	public void gameEndTopic(GameRuntimeBean gameRuntimeBean) {
		String destination = GameUrlHelp.topic_gameEnd+gameRuntimeBean.gameId;
		RspCommonBean rspCommonBean = RspCommonBean.getCommonRspBean(200,null);
		Map<String,Object> map = new HashMap<>(3);
		TQuestionsNew tQuestionsNew = gameRuntimeBean.tQuestions;
		map.put("tradeDay",tQuestionsNew.getTradeDay().replace("-","."));
		map.put("cnName",tQuestionsNew.getCnName());
		map.put("symbol",tQuestionsNew.getShortSymbol()+"."+tQuestionsNew.getExchangeCode());
		rspCommonBean.data = map;
		String str = JSON.toJSONString(rspCommonBean);
		simpMessagingTemplate.convertAndSend(destination, str);
	}

	/**
	 * 裁判端和客户端同步时间轴
	 * @param gameId
	 * @param xNow
	 */
	public void sendGameTimeLine(String gameId, int xNow) {
		String destination = GameUrlHelp.topic_gameTimeLine+gameId;
		RspCommonBean rspCommonBean = RspCommonBean.getCommonRspBean(200,null);
		Map<String,Object>  map = new HashMap<>(1);
		map.put("curIdx",xNow);
		rspCommonBean.data = map;
		String str = JSON.toJSONString(rspCommonBean);
//		logger.info(str);
		simpMessagingTemplate.convertAndSend(destination, str);
	}
}
