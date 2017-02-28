package cn.hkfdt.xiaot.websocket.topic;

import cn.hkfdt.xiaot.common.beans.GameUserBean;
import cn.hkfdt.xiaot.common.beans.RspCommonBean;
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
			itemTemp.headimgurl = itemT.headimgurl;
			itemTemp.userName = itemT.userName;
			itemTemp.userType = itemT.userType;
			itemTemp.returnRate = itemT.returnRate;
			listTar.add(itemTemp);
		});
		RspCommonBean rspCommonBean = RspCommonBean.getCommonRspBean(200,null);
		rspCommonBean.data = rankList;
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
		List<GameUserBean> listUser = new ArrayList<>();
		simpMessagingTemplate.convertAndSend(destination, listUser);
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
	 * 某比赛选手成绩更新后触发
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
			listTar.add(itemTemp);
		});
		RspCommonBean rspCommonBean = RspCommonBean.getCommonRspBean(200,null);
		rspCommonBean.data = listTar;
		String str = JSON.toJSONString(rspCommonBean);
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
		String destination = GameUrlHelp.topic_gameClientInfo+gameId;
		RspCommonBean rspCommonBean = RspCommonBean.getCommonRspBean(200,null);
		rspCommonBean.data = rankList;
		String str = JSON.toJSONString(rspCommonBean);
//		logger.info("send userRealtimeInfo length: "+str.length());
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
}
