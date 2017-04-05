package cn.hkfdt.xiaot.websocket.controllers;

import cn.hkfdt.xiaot.mybatis.mapper.ltschina.TRecordExtendsMapper;
import cn.hkfdt.xiaot.web.common.service.CommonService;
import cn.hkfdt.xiaot.web.common.service.TestDBServer;
import cn.hkfdt.xiaot.websocket.common.ClientAgentMng;
import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestControllerSk {

	@Autowired
	TRecordExtendsMapper testMapper;
	@Autowired
	CommonService commonService;
	@Autowired
	TestDBServer testDBServer;
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	private static Logger logger = LoggerFactory.getLogger(TestControllerSk.class);
	
	public static void main(String[] args){
		Map<String, Object>  map = new HashMap<String, Object>();
		map.put("rspCode", 200);
//		map.put("msg", "只有rspCode不为200的时候有错误，有这个属性");
		String str = JSON.toJSONString(map);
		System.err.println(str);
	}

	//=========================================================

	@MessageMapping("/queue/test/send")
	@SendToUser("/queue/test/send")
	public String testQueue(StompHeaderAccessor headers, String msg) {
		String sessionId = headers.getSessionId(); // SESSION_ID_HEADER = "simpSessionId";
		Map<String, Object>  mapTar = new HashMap<>(2);
		mapTar.put("serverHadRec",msg);
		String str = JSON.toJSONString(mapTar);
		logger.info(str);
		for(int i=0;i<1;i++) {
			ClientAgentMng.send(sessionId,"/queue/test/send", str);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//----------------------
//		String des = "/queue/test/send-user"+sessionId;
//		simpMessagingTemplate.convertAndSend(des,str);
		return str;
	}

	@MessageMapping("/topic/test/send")
	@SendToUser("/topic/test/send")
	public String testTopic(StompHeaderAccessor headerAccessor,@Payload(required = false)String msg) {
		if(StringUtils.isNullOrEmpty(msg)){
			return null;
		}
		Map<String, Object>  mapTar = new HashMap<>(2);
		mapTar.put("topic server Had Rec",msg);
		String str = JSON.toJSONString(mapTar);
		logger.info(str);
//		simpMessagingTemplate.convertAndSend("/topic/test/send", str);
		String userName = headerAccessor.getSessionId();
		String des = "/topic/test/send";///user/queue/test/send

		simpMessagingTemplate.convertAndSendToUser(userName,des,"我是数据");
		simpMessagingTemplate.convertAndSend("/user/"+userName+des,"我是数据222");

		return str;
	}
	//@Payload(required = false) 默认是true，如果没有数据就会报错
	@MessageMapping("/topic/test/send/*")//订阅不同的比赛，和返回不同比赛信息可以这么玩
	public void testTopic2(StompHeaderAccessor headerAccessor,@Payload(required = false)String msg) {
		if(StringUtils.isNullOrEmpty(msg)){
			return;
		}
//		Map<String, Object>  paraMap = getParaMap(headerAccessor,msg);
		Map<String, Object>  mapTar = new HashMap<>(2);
		mapTar.put("topic server Had Rec",msg);
		String str = JSON.toJSONString(mapTar);
		logger.info(str);
		simpMessagingTemplate.convertAndSend("/topic/test/send/1234", str);
	}


}
