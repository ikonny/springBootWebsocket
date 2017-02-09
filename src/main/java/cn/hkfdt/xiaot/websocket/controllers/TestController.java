package cn.hkfdt.xiaot.websocket.controllers;

import cn.hkfdt.xiaot.web.xiaot.mapper.TRecordExtendsMapper;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

	@Autowired
	TRecordExtendsMapper testMapper;
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	private static Logger logger = LoggerFactory.getLogger(TestController.class);
	
	public static void main(String[] args){
		Map<String, Object>  map = new HashMap<String, Object>();
		map.put("rspCode", 200);
//		map.put("msg", "只有rspCode不为200的时候有错误，有这个属性");
		String str = JSON.toJSONString(map);
		System.err.println(str);
	}

	//=========================================================
	@RequestMapping("/test/mybatis")
    @ResponseBody
	public Object mybatis(String id) {
		Map<String,Object> map = new HashMap<>(5);
		map.put("market",0);
		map.put("fdtId","mb000000377");
//		para = testMapper.getByUnionKey(para);
		int size = testMapper.getXiaotRecordTotal(map);
		System.out.println(size);
		return size;
	}

	@RequestMapping("/ws/test")
//    @ResponseBody
	public String http(String message) {
		System.out.println();
		return "test/nettyws";
	}
	@RequestMapping("/test/wss")
//    @ResponseBody
	public String https(String message) {
		System.out.println();
		return "test/wss";
	}

	@MessageMapping("/queue/test/send")
	@SendToUser("/queue/test/send")
	public String testQueue(SimpMessageHeaderAccessor headerAccessor,String msg) {
//		Map<String, Object>  paraMap = getParaMap(headerAccessor,msg);
		Map<String, Object>  mapTar = new HashMap<>(2);
		mapTar.put("serverHadRec",msg);

		String str = JSON.toJSONString(mapTar);
		logger.info(str);
		return str;
	}

	@MessageMapping("/topic/test/send")
	public void testTopic(SimpMessageHeaderAccessor headerAccessor,String msg) {
//		Map<String, Object>  paraMap = getParaMap(headerAccessor,msg);
		Map<String, Object>  mapTar = new HashMap<>(2);
		mapTar.put("serverHadRec",msg);
		String str = JSON.toJSONString(mapTar);
		logger.info(str);
		simpMessagingTemplate.convertAndSend("/topic/test/send", str);
	}


}
