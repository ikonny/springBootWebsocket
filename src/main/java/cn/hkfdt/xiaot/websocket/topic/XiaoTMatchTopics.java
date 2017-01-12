package cn.hkfdt.xiaot.websocket.topic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import cn.hkfdt.xiaot.websocket.conmng.WebSocketConnectionListener;
import cn.hkfdt.xiaot.websocket.protocol.ProtocolHelper;
import cn.hkfdt.xiaot.websocket.service.impl.MatchServiceHelper;

@Component
public class XiaoTMatchTopics {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	private static Logger logger = Logger.getLogger(WebSocketConnectionListener.class);
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
	@PostConstruct
	public void init(){
		MatchServiceHelper.xiaoTMatchTopics = this;
	}
	/**
	 * 通知本次比赛参加人开始比赛
	 * @param message
	 * @return
	 * author:xumin 
	 * 2017-1-10 下午5:23:07
	 */
//	@SendTo("/topic/match/start")  //广播
	public String start(String matchId) {
		final String destination = "/topic/match/start";
//		Map<String, Object> mapMatch = MatchServiceHelper.mapMatchInfo.get(matchId);
//		Map<String, Object> matchPeople = (Map<String, Object>) mapMatch.get("matchPeople");
//		List<String> fdtIdList = new ArrayList<String>(matchPeople.size());
//		for(String key : matchPeople.keySet()){
//			fdtIdList.add(key);
//		}
		simpMessagingTemplate.convertAndSend(destination, matchGo);
//		simpMessagingTemplate.convertAndSendToUser(user, "/topic/match/start", matchGo);
		return matchGo;
	}
	/**
	 * 某比赛选手成绩更新后触发
	 * 排行榜计算完毕，并通知订阅此接口的用户.注意后面区分比赛id
	 * @param rankList
	 * @return
	 * author:xumin 
	 * 2017-1-10 下午5:24:07
	 */
//	@SendTo("/topic/match/rankList")  //广播
	public String rankList(List<Map<String, Object>> rankList) {
		Map<String, Object> mapTar = new HashMap<String, Object>(3);
		mapTar.put("rspCode", 200);
		List<Map<String, Object>>  listMap = new ArrayList<Map<String,Object>>(rankList.size());
		for(Map<String, Object> map : rankList){
			Map<String, Object> item = new HashMap<String, Object>(8);
			item.put("fdtId", map.get("fdtId"));
			item.put("nickName", map.get("nickName"));
			item.put("yieldRate", map.get("yieldRate"));
			item.put("tradeCount", map.get("tradeCount"));
			
			listMap.add(item);
		}
		mapTar.put("rankList", listMap);
		String str = JSON.toJSONString(listMap);
//		System.out.println("send rankList: " + str);
		simpMessagingTemplate.convertAndSend("/topic/match/rankList", str);
		return str;
	}
	/**
	 * 某比赛选手成绩更新后触发
	 * 透传给裁判页面打开的相关人
	 * @param rankList
	 * @return
	 * author:xumin 
	 * 2017-1-10 下午5:25:46
	 */
//	@SendTo("/topic/match/userRealtimeInfo")  //广播
	public String userRealtimeInfo(List<Map<String, Object>> rankList) {
		Map<String, Object> mapTar = new HashMap<String, Object>(3);
		List<Map<String, Object>>  listMap = new ArrayList<Map<String,Object>>(rankList.size());
		for(Map<String, Object> map : rankList){
			Map<String, Object> item = new HashMap<String, Object>(8);
			item.put("fdtId", map.get("fdtId"));
			item.put("nickName", map.get("nickName"));
			item.put("yieldRate", map.get("yieldRate"));
			item.put("tradeCount", map.get("tradeCount"));
			item.put("curIdx", map.get("curIdx"));
			item.put("drawOption", map.get("drawOption"));
			
			item.put("preClosePrice", map.get("preClosePrice"));//fdtId
			item.put("curClosePrice", map.get("curClosePrice"));//fdtId
			item.put("curMa", map.get("curMa"));//fdtId
			item.put("curVolume", map.get("curVolume"));//fdtId
			
			listMap.add(item);
		}
		mapTar.put("rankList", listMap);
		String str = JSON.toJSONString(listMap);
//		System.out.println("send userRealtimeInfo length: "+str.length());
		simpMessagingTemplate.convertAndSend("/topic/match/userRealtimeInfo", str);
		return str;
	}

}
