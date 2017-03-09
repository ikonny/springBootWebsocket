package cn.hkfdt.xiaot.web.xiaot.service.impl;

import cn.hkfdt.xiaot.mybatis.model.ltschina.TQuestions;
import cn.hkfdt.xiaot.util.TimeUtil;
import cn.hkfdt.xiaot.web.common.LogUtil;
import cn.hkfdt.xiaot.web.xiaot.service.md.XiaoTMDDBHelper;
import cn.hkfdt.xiaot.web.xiaot.util.NetUtil;
import cn.hkfdt.xiaot.web.xiaot.util.XiaoTMarketType;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class XiaoTHelp {

	static Logger logger = LoggerFactory.getLogger(XiaoTHelp.class);
	//http://121.43.73.191:8082
	/**
	 * 如果xiaoT本次修改影响打分等历史数据，则该字段+1
	 */
	public static int version = 1;
	public static  String urlPickTrade = "/api/puzzle";//选题地址
	public static  String urlGetScore = "/api/scoring";//打分
	public static  String urlForceAnalysis = "/api/profile";//战力分析
	public static ExecutorService executorService = Executors.newCachedThreadPool();
	static DecimalFormat dfXt = new DecimalFormat("0.00");
	public static final String xiaoTGuest = "coach-t-guest";
	public static String xiaoTBigDataServer = null;
	public static final String xiaoTBigDataServerKey = "xiaoTBigDataServerKey";
	//=======================================================================
	public static void init(JdbcTemplate jdbcTemplate) {
		Map<String, Object> map = XiaoTMDDBHelper.getPerSistentInfo(xiaoTBigDataServerKey);
		if(map==null || map.isEmpty()){
			System.err.println("数据库配置出错，行情数据库等出错");
			return;
		}
		String valuejson = map.get("valuejson").toString();
		map = JSON.parseObject(valuejson);//(Map<String, Object>) JsonUtil.JsonToOb(valuejson, map.getClass());
		xiaoTBigDataServer = map.get("address").toString();
		urlPickTrade = xiaoTBigDataServer+urlPickTrade;
		urlGetScore = xiaoTBigDataServer+urlGetScore;
		urlForceAnalysis = xiaoTBigDataServer+urlForceAnalysis;
	}
	/**
	 * @param args
	 * author:xumin 
	 * 2016-12-15 下午4:27:49
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		xiaoTBigDataServer = "http://121.43.73.191:8082";//192.168.4.139  121.43.73.191:8082
		urlPickTrade = xiaoTBigDataServer+urlPickTrade;
		urlGetScore = xiaoTBigDataServer+urlGetScore;
		urlForceAnalysis = xiaoTBigDataServer+urlForceAnalysis;
//		Map<String, Object> map = new HashMap<String, Object>(6);
//		map.put("address", "http://121.43.73.191:8082");
//		String str = JsonUtil.ObToJson(map);
//		System.err.println(str);
		
//		System.err.println(get2Point(2.0001));
//		TQuestions date = getTQuestion("test", 0);
//		System.err.println(date);
		
//

//		final String name = "mb00aaaa";
//		Map<String, Object> mapDF = testxiaotDoScore(name);
//		System.err.println(mapDF);
		
//		
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				Map<String, Object> mapZL = getXiaoTZL("mb000001001", "");//战力
				System.err.println(mapZL);
			}
		};
		XiaoTHelp.executorService.execute(run);
		XiaoTHelp.executorService.shutdown();
		
	}
	private static Map<String, Object> testxiaotDoScore(String name) {
		// TODO Auto-generated method stub
		Map<String, Object> mapTar = new HashMap<String, Object>(8);
		mapTar.put("returnRate", -0.5);
		mapTar.put("volatility", 1.0);
		mapTar.put("market", "FC");
		mapTar.put("fdtId", name);
		
		mapTar.put("exchangeCode", "DCE");
		mapTar.put("symbol", "A");
		mapTar.put("key", "DCE#A#2016-05-19");
		mapTar.put("version", version);
		
		List<Map<String, Object>>  actions = new ArrayList<Map<String,Object>>(2);
		mapTar.put("actions", actions);
		
		Map<String, Object> map = new HashMap<String, Object>(3);
		map.put("timestamp", 1482912911901l);
		map.put("side", "buy");
		map.put("price", 878.5);
		
//		actions.add(map);
		
		
		
		String str = JSON.toJSONString(mapTar);//JsonUtil.ObToJson(mapTar);
		System.out.println(str);
//		str = URLEncoder.encode(str);
		
		return xiaotDoScore(str);
	}
	//===============================================================
	/**
	 * 四舍五入2位小数点
	 * @param price
	 * @return
	 * author:xumin 
	 * 2016-7-8 下午4:15:26
	 */
	public static String get2Point(Double price) {
		BigDecimal bd = new BigDecimal(price);
		double number = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return dfXt.format(number);
	}
	/**
	 * 从远程服务中获取某人某市场的选题。
	 * 成功返回联合主键结构体。否则为null
	 * @param fdtId
	 * @param market
	 * @return
	 * author:xumin 
	 * 2016-12-16 下午2:41:08
	 */
	@SuppressWarnings("unchecked")
	public static TQuestions getTQuestion(String fdtId, String market) {
		Map<String, Object> mapPara = new HashMap<String, Object>(3);
		mapPara.put("fdtId", fdtId);
		mapPara.put("version", version);
		mapPara.put("market", market);

		String json = JSON.toJSONString(mapPara);//JsonUtil.ObToJson(mapPara);
		
		String retStr = NetUtil.sendPostJson(urlPickTrade, json);//HttpUtils.postJson(urlPickTrade, json);
		mapPara = JSON.parseObject(retStr);//(Map<String, Object>) JsonUtil.JsonToOb(retStr, mapPara.getClass());
		TQuestions para = null;
		if(mapPara!=null ){
			int code = (int) mapPara.get("code");
			if(code==200){
				String[] strs = mapPara.get("unionKey").toString().split("#");
				para = new TQuestions();
				para.setExchangeCode(strs[0]);
				para.setShortSymbol(strs[1]);
				para.setTradeDay(strs[2]);
			}
		}
		return para;
	}
	/**
	 * 请求打分
	 * @param body
	 * @return
	 * author:xumin 
	 * 2016-12-19 下午3:38:38
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> xiaotDoScore(String body) {
		Map<String, Object> mapPara = new HashMap<String, Object>(3);
//		mapPara.put("version", version);
		String retStr =  NetUtil.sendPostJson(urlGetScore, body);//HttpUtils.postJson(urlGetScore, body);
		mapPara = JSON.parseObject(retStr);//(Map<String, Object>) JsonUtil.JsonToOb(retStr, mapPara.getClass());
		return mapPara;
	}
	/**
	 * 请求战力分析
	 * @param fdtId
	 * @param body
	 * @return
	 * author:xumin 
	 * 2016-12-19 下午4:16:58
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getXiaoTZL(String fdtId, String body) {
		Map<String, Object> mapPara = new HashMap<String, Object>(11);
		mapPara.put("fdtId", fdtId);
		mapPara.put("version", version);
		String date = TimeUtil.getDayNow();
		mapPara.put("date", date);
		mapPara.put("market", XiaoTMarketType.FC.getCode());// FC/FX/SC
		String json = JSON.toJSONString(mapPara);//JsonUtil.ObToJson(mapPara);
		
		String retStr = NetUtil.sendPostJson(urlForceAnalysis, json);//HttpUtils.postJson(urlForceAnalysis, json);
		System.err.println(urlForceAnalysis);
		mapPara = JSON.parseObject(retStr);//(Map<String, Object>) JsonUtil.JsonToOb(retStr, mapPara.getClass());
		return mapPara;
	}
	public static String getTKey(TQuestions tQuestions) {
		//"DCE#BB#2016-08-12
		String str = tQuestions.getExchangeCode()+"#"+tQuestions.getShortSymbol()+"#"+tQuestions.getTradeDay();
		return str;
	}
	public static String getMarketCode(TQuestions tQuestions) {
		int type = tQuestions.getType();
		if(type==XiaoTMarketType.FC.getType())
			return XiaoTMarketType.FC.getCode();
		if(type==XiaoTMarketType.FX.getType())
			return XiaoTMarketType.FX.getCode();
		if(type==XiaoTMarketType.SC.getType())
			return XiaoTMarketType.SC.getCode();
		return "FC";
	}
	/**
	 * 返回code
	 * @param type 0,fc  1,fx  2,sc
	 * @return
	 */
	public static String getMarketCode(int type) {
		if(type==0)
			return XiaoTMarketType.FC.getCode();
		if(type==1)
			return XiaoTMarketType.FX.getCode();
		if(type==2)
			return XiaoTMarketType.SC.getCode();
		return "FC";
	}
	public static void testRemoteServer() {
		try {
			TQuestions tq = getTQuestion(xiaoTGuest, "FC");
			if(tq!=null){
				logger.info("xiaot 选题server OK");
			}
		}catch (Exception e){
			LogUtil.logSensitive("xiaot 选题server Bad!!!!!!!!!!");
		}
	}
}
