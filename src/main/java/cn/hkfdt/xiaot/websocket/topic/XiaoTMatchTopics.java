package cn.hkfdt.xiaot.websocket.topic;

import cn.hkfdt.xiaot.common.beans.GameUserBean;
import cn.hkfdt.xiaot.common.beans.RspCommonBean;
import cn.hkfdt.xiaot.websocket.Beans.GameRuntimeBean;
import cn.hkfdt.xiaot.websocket.Beans.GameUserExtBean;
import cn.hkfdt.xiaot.websocket.Beans.GameUserListBean;
import cn.hkfdt.xiaot.websocket.service.impl.MatchServiceHelper;
import cn.hkfdt.xiaot.websocket.utils.GameUrlHelp;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		List<GameUserBean> listUser = new ArrayList<>();
		gameRuntimeBean.mapUsers.values().forEach(itme->{
			GameUserBean itemNew = new GameUserBean();
			itemNew.userId = itme.userId;
			itemNew.headimgurl = itme.headimgurl;
			itemNew.userName = itme.userName;
			itemNew.userType = itme.userType;

			listUser.add(itemNew);
		});
		RspCommonBean rspCommonBean = RspCommonBean.getCommonRspBean(200,null);
		rspCommonBean.data = listUser;
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
	public String rankList(List<GameUserExtBean> rankList, String gameId) {
		String destination = GameUrlHelp.topic_gameListInfo+gameId;
		List<GameUserListBean> listTar = new ArrayList<>(rankList.size());
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
		});
		RspCommonBean rspCommonBean = RspCommonBean.getCommonRspBean(200,null);
		rspCommonBean.data = listTar;
		String str = JSON.toJSONString(rspCommonBean);
		//-------记录运行时排行榜------------
		GameRuntimeBean gameRuntimeBean = (GameRuntimeBean) MatchServiceHelper.cacheMapXM.get(gameId);
		if(gameRuntimeBean !=null){
			gameRuntimeBean.listRank = listTar;
		}
		//---------------------------------
//		logger.info("send rankList: " + str);
		simpMessagingTemplate.convertAndSend(destination, str);
		return str;
	}
	/**
	 * 某比赛选手成绩更新后触发
	 * 透传给裁判页面打开的相关人
	 * @param rankList
	 * @param gameId
	 * @return
	 * author:xumin 
	 * 2017-1-10 下午5:25:46
	 */
	public String userRealtimeInfo(List<GameUserExtBean> rankList, String gameId) {
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

	public void gameEndTopic(String gameId) {
		String destination = GameUrlHelp.topic_gameEnd+gameId;
		RspCommonBean rspCommonBean = RspCommonBean.getCommonRspBean(200,null);
		rspCommonBean.data = gameId;
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
