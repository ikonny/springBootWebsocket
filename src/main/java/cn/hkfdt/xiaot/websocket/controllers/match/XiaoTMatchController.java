package cn.hkfdt.xiaot.websocket.controllers.match;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hkfdt.xiaot.websocket.conmng.WebSocketConnectionListener;
import cn.hkfdt.xiaot.websocket.protocol.ProtocolHelper;
import cn.hkfdt.xiaot.websocket.service.MatchService;
import cn.hkfdt.xiaot.websocket.topic.XiaoTMatchTopics;

import com.alibaba.fastjson.JSON;

@Controller
public class XiaoTMatchController {

	@Autowired
	MatchService matchService;
	@Autowired
	XiaoTMatchTopics xiaoTMatchTopics;
	private static Logger logger = Logger.getLogger(WebSocketConnectionListener.class);
	
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

	@SuppressWarnings("unchecked")
	@MessageMapping("/match/getMatch") //这个不同于@RequestMapping 是专门用于websoket的
//	@SendTo("/queue/xiaot/match/getMatch")  //广播
	@SendToUser("/queue/match/getMatch")    //需要订阅的时候前面加个
	public String getMatch(SimpMessageHeaderAccessor headerAccessor,String msg) {
		
		Map<String, Object>  paraMap = getParaMap(headerAccessor,msg);
		String jsonRsp = matchService.getMatch(paraMap);
		Map<String, Object>  mapTar = JSON.parseObject(jsonRsp, paraMap.getClass());
		mapTar.put("fdtId", paraMap.get("fdtId"));
//		simpMessagingTemplate.convertAndSend("/topic/entries", message);
//		simpMessagingTemplate.convertAndSendToUser(user, destination, payload)
		return JSON.toJSONString(mapTar);
	}
	/**
	 * 把jaon转化成map 并增加sessionId,fdtId
	 * @param headerAccessor
	 * @param msg
	 * @return
	 * author:xumin 
	 * 2017-1-11 下午3:42:36
	 */
	@SuppressWarnings("unchecked")
	public static HashMap<String, Object> getParaMap(SimpMessageHeaderAccessor headerAccessor, String msg) {
		HashMap<String, Object> tar = JSON.parseObject(msg, HashMap.class);
		String sessionId = headerAccessor.getSessionId(); // Session ID
		String fdtId = WebSocketConnectionListener.mapSession2FdtId.get(sessionId);
		tar.put("sessionId", sessionId);
		tar.put("fdtId", fdtId);
//		System.out.println(tar);
		return tar;
	}

	@MessageMapping("/match/ready")
	@SendToUser("/queue/match/ready")
	public String ready(SimpMessageHeaderAccessor headerAccessor,String msg) {
		Map<String, Object>  paraMap = getParaMap(headerAccessor, msg);
		int flag = matchService.ready(paraMap);
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
		logger.info("ready:"+str);
		return str;
	}
	
	
	@MessageMapping("/match/sendClientMatchInfo")
	public void sendClientMatchInfo(SimpMessageHeaderAccessor headerAccessor,String msg) {
		Map<String, Object>  paraMap = getParaMap(headerAccessor, msg);
		matchService.sendClientMatchInfo(paraMap);
	}

}
