package cn.hkfdt.xiaot.websocket.controllers.match;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hkfdt.xiaot.websocket.protocol.ProtocolHelper;
import cn.hkfdt.xiaot.websocket.service.MatchService;
import cn.hkfdt.xiaot.websocket.service.impl.MatchServiceHelper;
import cn.hkfdt.xiaot.websocket.topic.XiaoTMatchTopics;

import com.alibaba.fastjson.JSON;

@Controller
public class XiaoTMatchController {

	@Autowired
	MatchService matchService;
	@Autowired
	XiaoTMatchTopics xiaoTMatchTopics;
	
	public static void main(String[] args){
		Map<String, Object>  map = new HashMap<String, Object>();
		map.put("rspCode", 200);
//		map.put("msg", "只有rspCode不为200的时候有错误，有这个属性");
		String str = JSON.toJSONString(map);
		System.err.println(str);
	}

	//==================================================
	@RequestMapping("/test")
	@ResponseBody
	public String http(String message) {
		return message+"sdf";
	}

	@MessageMapping("/match/getMatch") //这个不同于@RequestMapping 是专门用于websoket的
//	@SendTo("/queue/xiaot/match/getMatch")  //广播
	@SendToUser("/queue/match/getMatch")    //需要订阅的时候前面加个
	public String getMatch(SimpMessageHeaderAccessor headerAccessor,String msg) {
		
		String sessionId = headerAccessor.getSessionId(); // Session ID
		System.out.println("getMatch message: " + msg+"  sessionId:"+sessionId);
		Map<String, Object>  paraMap = getParaMap(msg);
		paraMap.put("sessionId", sessionId);
		String jsonRsp = matchService.getMatch(paraMap);
//		simpMessagingTemplate.convertAndSend("/topic/entries", message);
//		simpMessagingTemplate.convertAndSendToUser(user, destination, payload)
		return jsonRsp;
	}
	
	@SuppressWarnings("unchecked")
	public static HashMap<String, Object> getParaMap(String msg) {
		return JSON.parseObject(msg, HashMap.class);
	}

	@MessageMapping("/match/ready")
	@SendToUser("/queue/match/ready")
	public String ready(SimpMessageHeaderAccessor headerAccessor,String msg) {
		String sessionId = headerAccessor.getSessionId(); // Session ID
		System.out.println("ready message: " + msg+"  sessionId:"+sessionId);
		Map<String, Object>  paraMap = getParaMap(msg);
		paraMap.put("sessionId", sessionId);
		int flag = 0;//matchService.ready(paraMap);
		String msg2 ="";
		int rspCode = 200;
		if(flag==-2){
			rspCode = 201;
			msg2 = "比赛不存在";
		}
		if(flag==-1){
			rspCode = 201;
			msg2 = "比赛人数已满";
		}
		String str = ProtocolHelper.getCommonJson(rspCode,msg2);
		
		//---------下面是测试数据------------------
		final String matchId = paraMap.get("matchId").toString();
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				xiaoTMatchTopics.start(matchId);
			}
		};
		MatchServiceHelper.executorService.execute(run);
		//--------------------------
		return str;
	}
	
	
	@MessageMapping("/match/sendClientMatchInfo")
	public void sendClientMatchInfo(SimpMessageHeaderAccessor headerAccessor,String msg) {
		String sessionId = headerAccessor.getSessionId(); // Session ID
		System.out.println("sendClientMatchInfo message: " + msg+"  sessionId:"+sessionId);
		Map<String, Object>  paraMap = getParaMap(msg);
		paraMap.put("sessionId", sessionId);
		matchService.sendClientMatchInfo(paraMap);
	}

}
