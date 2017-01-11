package cn.hkfdt.xiaot.websocket.topic;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import cn.hkfdt.xiaot.websocket.protocol.ProtocolHelper;
import cn.hkfdt.xiaot.websocket.service.impl.MatchServiceHelper;

@Component
public class XiaoTMatchTopics {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	public static String matchGo;
	static{
		Map<String, Object> map = new HashMap<String, Object>(2);
		map.put("rspCode", 200);
		map.put("action", "go");
		matchGo = JSON.toJSONString(map);
	}
	/**
	 * @param args
	 * author:xumin 
	 * 2017-1-10 下午4:57:16
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//==================================================================== 
	/**
	 * 通知本次比赛参加人开始比赛
	 * @param message
	 * @return
	 * author:xumin 
	 * 2017-1-10 下午5:23:07
	 */
//	@SendTo("/topic/match/start")  //广播
	public String start(String matchId) {
		System.out.println("Received message: " + matchId);
		final String destination = "/topic/match/start";
		Map<String, Object> mapMatch = MatchServiceHelper.mapMatchInfo.get(matchId);
		Map<String, Object> matchPeople = (Map<String, Object>) mapMatch.get("matchPeople");
		for(String key : matchPeople.keySet()){
			simpMessagingTemplate.convertAndSendToUser(key, destination, matchGo);
		}
		simpMessagingTemplate.convertAndSend("/topic/match/start", matchGo);
//		simpMessagingTemplate.convertAndSendToUser(user, destination, payload)
		return matchGo;
	}
	/**
	 * 某比赛选手成绩更新后触发
	 * 排行榜计算完毕，并通知订阅此接口的用户.注意后面区分比赛id
	 * @param message
	 * @return
	 * author:xumin 
	 * 2017-1-10 下午5:24:07
	 */
	@SendTo("/topic/match/rankList")  //广播
	public String rankList(String message) {
		System.out.println("Received message: " + message);
		return message+"徐岷";
	}
	/**
	 * 某比赛选手成绩更新后触发
	 * 透传给裁判页面打开的相关人
	 * @param message
	 * @return
	 * author:xumin 
	 * 2017-1-10 下午5:25:46
	 */
	@SendTo("/topic/match/userRealtimeInfo")  //广播
	public String userRealtimeInfo(String message) {
		System.out.println("Received message: " + message);
		return message;
	}

}
