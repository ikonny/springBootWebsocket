package cn.hkfdt.xiaot.web.xiaot.web.test;

import cn.hkfdt.xiaot.mybatis.mapper.ltschina.TRecordExtendsMapper;
import cn.hkfdt.xiaot.mybatis.model.fxchina.SystemSettings;
import cn.hkfdt.xiaot.web.common.LogUtil;
import cn.hkfdt.xiaot.web.common.service.CommonService;
import cn.hkfdt.xiaot.web.common.service.TestDBServer;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

	@Autowired
	TRecordExtendsMapper testMapper;
	@Autowired
	CommonService commonService;
	@Autowired
	TestDBServer testDBServer;
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
	@RequestMapping("/xiaoth/mybatis")
    @ResponseBody
	public Object mybatis(String id) {
		Map<String,Object> map = new HashMap<>(5);
		map.put("market",0);
		map.put("fdtId","mb000000377");
//		para = testMapper.getByUnionKey(para);
		int size = testMapper.getXiaotRecordTotal(map);
		System.out.println(size);

		SystemSettings str = commonService.getSystemSettingValue("xiaoT_version");
		logger.info(str.toString());
		LogUtil.logSensitive("asfdsafffffffffffffffff");
		return size;
	}
	/**
	 * 这个是用来测试soketjs的，有用
	 * @param message
	 * @return
	 */
	@RequestMapping("/xiaoth/wss")
//    @ResponseBody
	public String https(String message) {
		System.out.println();
		return "test/wss";
	}
	/**
	 * 这个是用来测试soketjs的，有用
	 * @param message
	 * @return
	 */
	@RequestMapping("/xiaoth/trans")
    @ResponseBody
	public String trans(String message) {
		new Thread(()->{testDBServer.transCASTest("11");}).start();
		new Thread(()->{testDBServer.transCASTest("22");}).start();
		return "ok";
	}

	@MessageMapping("/queue/test/send")
	@SendToUser("/queue/test/send")
	public String testQueue(StompHeaderAccessor headers, String msg) {
//		Map<String, Object>  paraMap = getParaMap(headerAccessor,msg);
		String sessionId = headers.getSessionId(); // SESSION_ID_HEADER = "simpSessionId";
//		String user = headers.getUser().getName(); //USER_HEADER = "simpUser";
		Map<String, Object>  mapTar = new HashMap<>(2);
		mapTar.put("serverHadRec",msg);
		String str = JSON.toJSONString(mapTar);
		logger.info(str);
//		int state = WebSocketConnectionListener.setUserIds(sessionId,sessionId+"__");
//		simpMessagingTemplate.convertAndSendToUser(sessionId,"/queue/test/send",str);//等价
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
