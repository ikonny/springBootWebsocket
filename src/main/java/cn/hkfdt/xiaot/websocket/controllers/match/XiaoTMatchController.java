package cn.hkfdt.xiaot.websocket.controllers.match;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hkfdt.xiaot.websocket.protocol.ProtocolHelper;

import com.alibaba.fastjson.JSON;

@Controller
public class XiaoTMatchController {

	public static void main(String[] args){
		Map<String, Object>  map = new HashMap<String, Object>();
		map.put("rspCode", 200);
//		map.put("msg", "只有rspCode不为200的时候有错误，有这个属性");
		String str = JSON.toJSONString(map);
		System.err.println(str);
	}

	//==================================================
	@RequestMapping("getSession")
	@ResponseBody
	public String getSession(HttpSession session) {
		System.out.println(session.getId());
		return "index";
	}
	@RequestMapping("/test")
	@ResponseBody
	public String http(String message) {
		return message+"sdf";
	}

	@MessageMapping("/match/getMatch") //这个不同于@RequestMapping 是专门用于websoket的
//	@SendTo("/queue/xiaot/match/getMatch")  //广播
	@SendToUser("/queue/match/getMatch")    //需要订阅的时候前面加个
	public String getMatch(SimpMessageHeaderAccessor headerAccessor ,String msg) {
		
		String sessionId = headerAccessor.getSessionId(); // Session ID
		System.out.println("Received message: " + msg+"  sessionId:"+sessionId);
		HashMap<String, Object>  paraMap = getParaMap(msg);
		
		//1.如果比赛id没有就内存创建比赛，比赛id为key,后面是比赛信息，包括人数，参加人数，比赛题目。
		//2.如果比赛id已经有了，就更新比赛信息主要是人数，这边对同一个比赛加锁，如果人数已经达到就调用
//		simpMessagingTemplate.convertAndSend("/topic/entries", message);
//		simpMessagingTemplate.convertAndSendToUser(user, destination, payload)
		return ProtocolHelper.OK;
	}
	
	@SuppressWarnings("unchecked")
	public static HashMap<String, Object> getParaMap(String msg) {
		return JSON.parseObject(msg, HashMap.class);
	}

	@MessageMapping("/match/ready")
	@SendToUser("/queue/match/ready")
	public String ready(String message) {
		System.out.println("Received message: " + message);
		return ProtocolHelper.OK;
	}

}
