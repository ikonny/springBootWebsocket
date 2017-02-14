package cn.hkfdt.xiaot.web.xiaot.web;

import cn.hkfdt.xiaot.mybatis.model.ltschina.ForceAnalysis;
import cn.hkfdt.xiaot.util.QrCodeUtil;
import cn.hkfdt.xiaot.web.Filters.LoginFilter;
import cn.hkfdt.xiaot.web.common.UserContext;
import cn.hkfdt.xiaot.web.common.globalinit.GlobalInfo;
import cn.hkfdt.xiaot.web.common.service.CommonService;
import cn.hkfdt.xiaot.web.xiaot.service.XiaoTService;
import cn.hkfdt.xiaot.web.xiaot.service.impl.XiaoTHelp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * author:xumin 
 * 2016-12-15 下午3:18:11
 */
@Controller
public class XiaoTController {

	static Logger logger = LoggerFactory.getLogger(XiaoTController.class);
	@Autowired
	XiaoTService xiaoTService;
	@Autowired
	CommonService commonService;

	//=========================================
	/**
	 * 请求选题并且开做
	 * @param market 0：期货  1:股票  2：外汇
	 * @param model
	 * @return
	 * author:xumin 
	 * 2016-12-16 上午9:58:34
	 */
	@RequestMapping(value="/im/xiaotTraining")
	@ResponseBody
    public Object xiaotTraining(@RequestParam(defaultValue = "0") int market, Model model){
		Map<String, Object> mapTar = new HashMap<String, Object>(8);
		String fdtId = UserContext.getUserInfo().get().getFdtId();
		if(LoginFilter.isNotLogin(fdtId)){
			fdtId = XiaoTHelp.xiaoTGuest;
		}
        xiaoTService.xiaotTraining(fdtId,market,mapTar);
//        String jsonData = mapTar.get("jsonData").toString();
        return mapTar;
    }
	/**
	 * 
	 * @param body json数据，用户完成练习，将题目id和买卖点返回
	 * @param model
	 * @return
	 * author:xumin 
	 * 2016-12-19 下午3:13:10
	 */
	@RequestMapping(value="/im/xiaotDoScore")
	@ResponseBody
    public Object xiaotDoScore(@RequestBody String body, Model model){
    	
		Map<String, Object> mapTar = new HashMap<String, Object>(8);
		String fdtId = UserContext.getUserInfo().get().getFdtId();
		if(LoginFilter.isNotLogin(fdtId)){
			fdtId = XiaoTHelp.xiaoTGuest;
		}
        int flag = xiaoTService.xiaotDoScore(fdtId,body,mapTar);
//		System.err.println(body);
        return mapTar;
    }
	
	/**
	 * 小T训练营首页
	 * @param model
	 * @return
	 * author:xumin 
	 * 2016-12-15 下午5:02:06
	 */
	@RequestMapping(value="/im/xiaot/{other}")
    public String xiaot(@PathVariable String other, Model model){
		//{"lib":"1.1.10", "liveVideo":"1.1.10"}
		Map<String,Object>  mapTar = commonService.getSystemSettingValueAsMap("xiaoT_version");
        model.addAttribute("lib_version", mapTar.get("lib"));
        model.addAttribute("xiaoT_version", mapTar.get("xiaoT"));
        model.addAttribute("baseUrl", GlobalInfo.getBaseSSLUrl());
		return "xiaot/index";
    }

	/**
	 * 小T训练营首页2级路径版本
	 * @param model
	 * @return
	 * author:xumin
	 * 2016-12-15 下午5:02:06
	 */
	@RequestMapping(value="/im/xiaot/{other}/{param}")
	public String xiaot2path(@PathVariable String other, @PathVariable String param, Model model){
		//{"lib":"1.1.10", "liveVideo":"1.1.10"}
		Map<String,Object>  mapTar = commonService.getSystemSettingValueAsMap("xiaoT_version");
		model.addAttribute("lib_version", mapTar.get("lib"));
		model.addAttribute("xiaoT_version", mapTar.get("xiaoT"));
		model.addAttribute("baseUrl", GlobalInfo.getBaseSSLUrl());
		return "xiaot/index";
	}
	/**
	 * 获取某人的战力分析
	 * @param market 0：期货  1:股票  2：外汇
	 * @param model
	 * @return
	 * author:xumin 
	 * 2016-12-15 下午4:55:38
	 */
    @RequestMapping(value="/im/getXiaotForceAnalysis")
    @ResponseBody
    public Object getXiaotForceAnalysis(
            @RequestParam(defaultValue = "0") int market, Model model){
    	
    	String fdtId = UserContext.getUserInfo().get().getFdtId();//"saf";//
        ForceAnalysis forceAnalysis = xiaoTService.getXiaotForceAnalysis(fdtId,market);
        Map<String, Object> mapTar = new HashMap<String, Object>(12);
        mapTar.put("status", 200);
        if(forceAnalysis!=null){
        	float fdtScore =  forceAnalysis.getFdtScore();
	        int tradeCount = forceAnalysis.getTradeCount();
	        int winCount = forceAnalysis.getWinCount();
	        String winRate = "0";
	        if(tradeCount!=0)
	        	winRate = XiaoTHelp.get2Point(winCount*100.0/tradeCount);
	        float maxDrawdown = forceAnalysis.getMaxDrawdown();
	        float sharpeRatio = forceAnalysis.getSharpeRatio();
	        float accumulatedIncome = forceAnalysis.getAccumulatedIncome();
	        
	        mapTar.put("score", fdtScore);
	        mapTar.put("tradeCount", tradeCount);
	        mapTar.put("winCount", winCount);
	        mapTar.put("maxDrawdown", maxDrawdown);
	        mapTar.put("sharpeRatio", sharpeRatio);
	        mapTar.put("winRate", winRate);
	        mapTar.put("accumulatedIncome", accumulatedIncome);
        }
        return mapTar;
    }
    /**
     * 获取某人的战绩
     * @param market 0：期货  1:股票  2：外汇
     * @param model
     * @return
     * author:xumin 
     * 2016-12-15 下午4:56:11
     */
    @RequestMapping(value="/im/getXiaotRecords")
    @ResponseBody
    public Object getXiaotRecord(
            @RequestParam(defaultValue = "0") int market, Model model,
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "1") int count){
    	
    	String fdtId = UserContext.getUserInfo().get().getFdtId();//"aa";//
    	Map<String, Object>  mapPara = new HashMap<String, Object>(6);
    	mapPara.put("fdtId", fdtId);
    	mapPara.put("market", market);
    	mapPara.put("offset", offset);
    	mapPara.put("count", count);
    	Map<String, Object>  mapTar = new HashMap<String, Object>(6);
        int flag = xiaoTService.getXiaotRecord(mapPara,mapTar);
        if(flag==0){
	//        model.addAttribute(attributeName, attributeValue)
        }
        return mapTar;
    }
    /**
     * 获取高手榜 100名，5分钟刷新一次
     * @param market 0：期货  1:股票  2：外汇
     * @param model
     * @return
     * author:xumin 
     * 2016-12-15 下午4:56:53
     */
//    @CacheControl(maxAge = 300, policy = CachePolicy.PRIVATE)  //不使用服务缓存
    @RequestMapping(value="/im/getXiaotMasterList")
    @ResponseBody
    public Object getXiaotMasterList(@RequestParam(defaultValue = "0") int market, Model model,
                                     @RequestParam(defaultValue = "false") boolean isflush){
    	
    	Map<String, Object> mapTar = new HashMap<String, Object>(3);
        List<Map<String, Object>> listMap = xiaoTService.getXiaotMasterList(market,isflush);
        mapTar.put("status", 200);
        mapTar.put("data", listMap);
        return mapTar;
    }
    
    //=============================================================
    @RequestMapping(value="/im/initTQuestions")
    @ResponseBody
    public String initTQuestions(@RequestParam(required = true) String xm, @RequestParam(defaultValue = "0") int market ){
    	
    	if(xm.equals("right")){
    		Map<String, Object> mapTar = new HashMap<String, Object>(6);
    		int flag = xiaoTService.initTQuestions(market,mapTar);
    	}else{
    		return "he he";
    	}
        return "尽力而为";
    }

	@RequestMapping(value = "/im/getQrCode")
	@ResponseBody
	public Object getQrCode(@RequestParam Integer num, Model model) {
		String url = GlobalInfo.getDomainHttp()+"/im/xiaot/game?type=battle";
//		if (ConfigService.isDevEnv()) {
//			url = "http://dev.forexmaster.cn/im/xiaot/game?type=battle";
//		} else if (ConfigService.isTestEnv()) {
//			url = "http://test.forexmaster.cn/im/xiaot/game?type=battle";
//		}
		String uuid = UUID.randomUUID().toString();
		url = url + "&matchId=" + uuid + "&num=" + num;
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("img", QrCodeUtil.createImage2Base64(url));
		resultMap.put("matchId", uuid);
		resultMap.put("url", url);
		return resultMap;
	}


}
