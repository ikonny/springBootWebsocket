package cn.hkfdt.xiaot.web.xiaot.web.test;

import cn.hkfdt.xiaot.mybatis.mapper.ltschina.TRecordExtendsMapper;
import cn.hkfdt.xiaot.mybatis.model.fxchina.SystemSettings;
import cn.hkfdt.xiaot.web.common.LogUtil;
import cn.hkfdt.xiaot.web.common.service.CommonService;
import cn.hkfdt.xiaot.web.common.service.TestDBServer;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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

}
