package cn.hkfdt.xiaot.web.xiaot.web;

import cn.hkfdt.xiaot.mybatis.mapper.ltschina.TQuestionsNewExtendsMapper;
import cn.hkfdt.xiaot.mybatis.model.ltschina.ForceAnalysis;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TQuestionsNew;
import cn.hkfdt.xiaot.web.Filters.LoginFilter;
import cn.hkfdt.xiaot.web.common.UserContext;
import cn.hkfdt.xiaot.web.common.globalinit.GlobalInfo;
import cn.hkfdt.xiaot.web.common.service.CommonService;
import cn.hkfdt.xiaot.web.weixin.WXHelper;
import cn.hkfdt.xiaot.web.xiaot.service.XiaoTService;
import cn.hkfdt.xiaot.web.xiaot.service.impl.XiaoTHelp;
import cn.hkfdt.xiaot.web.xiaot.service.md.XiaoTMDHelp;
import cn.hkfdt.xiaot.web.xiaot.util.YSUtils;
import com.alibaba.fastjson.JSON;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@Autowired
	TQuestionsNewExtendsMapper tQuestionsNewExtendsMapper;
	static String xiaoT_version = "xiaoT_version_1";

	//=========================================
	/**
	 * 请求选题并且开做。
	 * @param market 0：期货  1:股票  2：外汇
	 * @param type all：全部  history:历史  today：今日
	 * @param model
	 * @return
	 * author:xumin 
	 * 2016-12-16 上午9:58:34
	 */
	@RequestMapping(value="/xiaoth/xiaotTraining")
	@ResponseBody
    public Object xiaotTraining(@RequestParam(defaultValue = "FC") String market,
								@RequestParam(defaultValue = "all") String type, Model model){
		Map<String, Object> mapTar = new HashMap<String, Object>(8);
		String fdtId = UserContext.getUserInfo().get().getFdtId();
		if(LoginFilter.isNotLogin(fdtId)){
			fdtId = XiaoTHelp.xiaoTGuest;
		}
        xiaoTService.xiaotTraining(fdtId, market, mapTar, type);
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
	@RequestMapping(value="/xiaoth/xiaotDoScore")
	@ResponseBody
    public Object xiaotDoScore(@RequestBody String body, Model model){
    	
		Map<String, Object> mapTar = new HashMap<String, Object>(8);
		String fdtId = UserContext.getUserInfo().get().getFdtId();
		if(LoginFilter.isNotLogin(fdtId)){
			fdtId = XiaoTHelp.xiaoTGuest;
		}
		int flag = xiaoTService.xiaotDoScore(fdtId, body, mapTar);
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
	@RequestMapping(value="/xiaoth/xiaot/{other}")
    public String xiaot(HttpServletRequest request, @PathVariable String other, Model model,
						HttpServletResponse response){

		//{"lib":"1.1.10", "liveVideo":"1.1.10"}
//		String str = request.getRequestURI();
		Map<String,Object>  mapTar = commonService.getSystemSettingValueAsMap(xiaoT_version);
        model.addAttribute("lib_version", mapTar.get("lib"));
        model.addAttribute("xiaoT_version", mapTar.get("xiaoT"));

		String baseUrl = GlobalInfo.imDomain;
        model.addAttribute("baseUrl", baseUrl);
		//model.addAttribute("userInfo", URLDecoder.decode(userInfo));
		return "xiaot/index";
    }

	/**
	 * 小T训练营首页2级路径版本
	 * @param model
	 * @return
	 * author:xumin
	 * 2016-12-15 下午5:02:06
	 */
	@RequestMapping(value="/xiaoth/xiaot/{other}/{param}")
	public String xiaot2path(HttpServletRequest request, HttpServletResponse response, @PathVariable String other, @PathVariable String param, Model model, @RequestParam(defaultValue = "") String userInfo, @RequestParam(required = false) String gameId,
							 @RequestParam(required = false) String num) throws Exception{
		if("battle".equals(other) && WXHelper.isFromWx(request) && (userInfo == null || "".equalsIgnoreCase(userInfo))){//微信用打开,且没有用户信息
			//           logger.info("微信:"+GlobalInfo.wxLoginUrl);
			try {
				String targetUrl = GlobalInfo.wxLoginUrl.replace("theGameId", gameId).replace("theNum", num);
				response.sendRedirect(targetUrl);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		//{"lib":"1.1.10", "liveVideo":"1.1.10"}
//		String str = request.getRequestURI();
		Map<String,Object>  mapTar = commonService.getSystemSettingValueAsMap(xiaoT_version);
		model.addAttribute("lib_version", mapTar.get("lib"));
		model.addAttribute("xiaoT_version", mapTar.get("xiaoT"));

		String baseUrl = GlobalInfo.imDomain;
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("userInfo", URLDecoder.decode(userInfo, "utf-8"));
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
    @RequestMapping(value="/xiaoth/getXiaotForceAnalysis")
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
    @RequestMapping(value="/xiaoth/getXiaotRecords")
    @ResponseBody
    public Object getXiaotRecord(
            @RequestParam(defaultValue = "FC") String market, Model model,
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
    @RequestMapping(value="/xiaoth/getXiaotMasterList")
    @ResponseBody
    public Object getXiaotMasterList(@RequestParam(defaultValue = "0") int market, Model model,
                                     @RequestParam(defaultValue = "false") boolean isflush){
    	
    	Map<String, Object> mapTar = new HashMap<>(3);
        List<Map<String, Object>> listMap = xiaoTService.getXiaotMasterList(market,isflush);
        mapTar.put("status", 200);
        mapTar.put("data", listMap);
        return mapTar;
    }
    
    //=============================================================
    @RequestMapping(value="/xiaoth/initTQuestions")
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

//	@RequestMapping(value = "/xiaoth/getQrCode")
//	@ResponseBody
//	public Object getQrCode(@RequestParam Integer num, Model model) {
//		String url = GlobalInfo.getDomainHttp()+"/xiaoth/xiaot/game?type=battle";
////		if (ConfigService.isDevEnv()) {
////			url = "http://dev.forexmaster.cn/im/xiaot/game?type=battle";
////		} else if (ConfigService.isTestEnv()) {
////			url = "http://test.forexmaster.cn/im/xiaot/game?type=battle";
////		}
//		String uuid = UUID.randomUUID().toString();
//		url = url + "&matchId=" + uuid + "&num=" + num;
//		Map<String, Object> resultMap = new HashMap<>();
//		resultMap.put("img", QrCodeUtil.createImage2Base64(url));
//		resultMap.put("matchId", uuid);
//		resultMap.put("url", url);
//		return resultMap;
//	}
	@RequestMapping(value="/xiaoth/addNewQuestions")
	public void addQuestions() throws Exception{
		this.addFc();
		this.addSc();


	}

	public void addFc() throws Exception{
		InputStream is = this.getClass().getResourceAsStream("/fc-1000");
		InputStreamReader read = new InputStreamReader(is);
		BufferedReader bufferedReader = new BufferedReader(read);
		String lineTxt = null;
		while((lineTxt = bufferedReader.readLine()) != null){
			Map<String, Object> map = JSON.parseObject(lineTxt);
			String key = map.get("key").toString();
			String cnName = map.get("name").toString();
			String[] keyArr = key.split("#");
			Map<String, Object> jsonDataMap = new HashMap<>();
			Map<String, Object> todayMap = (Map<String, Object>)map.get("today");
			List<Map<String, Object>> todayItemList = (List<Map<String, Object>>)todayMap.get("items");
			List<Map<String, Object>> today200ItemList = new ArrayList<>();
			Double maxVolatility = null;
			for (Map<String, Object> som : todayItemList) {
				if(maxVolatility == null || Double.parseDouble(som.get("volatility").toString()) > maxVolatility){
					maxVolatility = Double.parseDouble(som.get("volatility").toString());
				}
				som.put("closePrice", som.get("close"));
				today200ItemList.add(som);
				if(today200ItemList.size() >= 200){
					break;
				}
			}
			todayMap.put("volatility", XiaoTHelp.get2Point(maxVolatility));
			todayMap.put("items", today200ItemList);
			jsonDataMap.put("today", todayMap);
			Map<String, Object> historyMap = (Map<String, Object>)map.get("history");
			List<Map<String, Object>> historyItemList = (List<Map<String, Object>>)historyMap.get("items");
			int index = 0;
			List<Double> emaShort = new ArrayList<>();
			List<Double> emaLone = new ArrayList<>();
			List<Double> emaDea = new ArrayList<>();
			for (Map<String, Object> som : historyItemList) {
				som.put("closePrice", som.get("close"));
				setMacd(som, index++,emaShort,emaLone,emaDea);
			}
			historyMap.put("macdName", "MACD(12,26,9)");
			historyMap.put("items", historyItemList);
			jsonDataMap.put("history", historyMap);
			String jsonData = JSON.toJSONString(jsonDataMap);
			byte[] byteTar = YSUtils.compress(jsonData.getBytes(), 2);
			TQuestionsNew tq = new TQuestionsNew();
			tq.setExchangeCode(keyArr[0]);
			tq.setShortSymbol(keyArr[1]);
			tq.setTradeDay(keyArr[2]);
			tq.setCreateTime(System.currentTimeMillis());
			tq.setType(0);
			tq.setCnName(cnName);
			tq.setJsonData(byteTar);
			tq.setInitType(1);

			try {
				tQuestionsNewExtendsMapper.insertSelective(tq);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void addSc() throws Exception{
		InputStream is = this.getClass().getResourceAsStream("/sc-1000");
		InputStreamReader read = new InputStreamReader(is);
		BufferedReader bufferedReader = new BufferedReader(read);
		String lineTxt = null;
		while((lineTxt = bufferedReader.readLine()) != null){
			Map<String, Object> map = JSON.parseObject(lineTxt);
			String key = map.get("key").toString();
			String cnName = map.get("name").toString();
			String[] keyArr = key.split("#");
			Map<String, Object> jsonDataMap = new HashMap<>();
			Map<String, Object> todayMap = (Map<String, Object>)map.get("today");
			List<Map<String, Object>> todayItemList = (List<Map<String, Object>>)todayMap.get("items");
			List<Map<String, Object>> today200ItemList = new ArrayList<>();
			Double maxVolatility = null;
			for (Map<String, Object> som : todayItemList) {
				if(maxVolatility == null || Double.parseDouble(som.get("volatility").toString()) > maxVolatility){
					maxVolatility = Double.parseDouble(som.get("volatility").toString());
				}
				som.put("closePrice", som.get("close"));
				today200ItemList.add(som);
				if(today200ItemList.size() >= 242){
					break;
				}
			}
			todayMap.put("volatility", XiaoTHelp.get2Point(maxVolatility));
			todayMap.put("items", today200ItemList);
			jsonDataMap.put("today", todayMap);
			Map<String, Object> historyMap = (Map<String, Object>)map.get("history");
			List<Map<String, Object>> historyItemList = (List<Map<String, Object>>)historyMap.get("items");
			int index = 0;
			List<Double> emaShort = new ArrayList<>();
			List<Double> emaLone = new ArrayList<>();
			List<Double> emaDea = new ArrayList<>();
			for (Map<String, Object> som : historyItemList) {
				som.put("closePrice", som.get("close"));
				setMacd(som, index++,emaShort,emaLone,emaDea);
			}
			historyMap.put("macdName", "MACD(12,26,9)");
			historyMap.put("items", historyItemList);
			jsonDataMap.put("history", historyMap);
			String jsonData = JSON.toJSONString(jsonDataMap);
			byte[] byteTar = YSUtils.compress(jsonData.getBytes(), 2);
			TQuestionsNew tq = new TQuestionsNew();
			tq.setExchangeCode(keyArr[0]);
			tq.setShortSymbol(keyArr[1]);
			tq.setTradeDay(keyArr[2]);
			tq.setCreateTime(System.currentTimeMillis());
			tq.setType(1);
			tq.setCnName(cnName);
			tq.setJsonData(byteTar);
			tq.setInitType(1);

			try {
				tQuestionsNewExtendsMapper.insertSelective(tq);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void setMacd(Map<String, Object> item, int index, List<Double> emaShort,List<Double> emaLone,List<Double> emaDea){
		//计算macd start add by crimson 2017-02-22
		double diff = XiaoTMDHelp.EMA(index,Double.parseDouble(item.get("close").toString()),12,emaShort) - XiaoTMDHelp.EMA(index,Double.parseDouble(item.get("close").toString()),26,emaLone);
		item.put("diff", XiaoTHelp.get2Point(diff));// 变化快的线
		double dea = XiaoTMDHelp.EMA(index,diff,9,emaDea);
		item.put("dea", XiaoTHelp.get2Point(dea));// EMA diff 9后的线
		double macd = 2*(diff-dea);
		item.put("macd", XiaoTHelp.get2Point(macd));
		//计算macd end
	}

}
