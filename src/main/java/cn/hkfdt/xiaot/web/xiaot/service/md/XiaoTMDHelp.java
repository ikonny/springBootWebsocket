package cn.hkfdt.xiaot.web.xiaot.service.md;


import cn.hkfdt.xiaot.mybatis.model.TQuestions;
import cn.hkfdt.xiaot.util.DateUtil;
import cn.hkfdt.xiaot.web.xiaot.service.impl.XiaoTHelp;
import com.alibaba.fastjson.JSON;

import java.text.ParseException;
import java.util.*;

/**
 * 行情计算相关 author:xumin 2016-12-20 下午4:21:41
 */
public class XiaoTMDHelp {
	static Random random = new Random();
	static List<Double> emaShort = null;
	static List<Double> emaLone = null;
	static List<Double> emaDea = null;
	public static Map<String, Map<String, Object>> nM2JYS = new HashMap<String, Map<String, Object>>(70);
	static String zjJYSSt =  "CF";//中金
	static String sqJYSSt =  "SHF";//上期
	static String dsJYSSt =  "DCE";//大商
	static String zsJYSSt =  "CZC";//郑商
	static{
		//中金
		nM2JYS.put("IH", getADMap(zjJYSSt,"上证",300));
		nM2JYS.put("IC", getADMap(zjJYSSt,"中证",200));
		nM2JYS.put("IF", getADMap(zjJYSSt,"沪深",300));
		nM2JYS.put("T", getADMap(zjJYSSt,"十债",10000));
		nM2JYS.put("TF", getADMap(zjJYSSt,"五债",10000));
		nM2JYS.put("IO", getADMap(zjJYSSt,"股指期权",300));//??
		//上期
		nM2JYS.put("AL", getADMap(sqJYSSt,"铝",5));
		nM2JYS.put("AG", getADMap(sqJYSSt,"沪银",15));
		nM2JYS.put("AU", getADMap(sqJYSSt,"黄金",1000));
		nM2JYS.put("BU", getADMap(sqJYSSt,"沥青",10));
		nM2JYS.put("CU", getADMap(sqJYSSt,"沪铜",5));
		nM2JYS.put("FU", getADMap(sqJYSSt,"燃油",50));
		nM2JYS.put("HC", getADMap(sqJYSSt,"卷板",10));
		nM2JYS.put("NI", getADMap(sqJYSSt,"沪镍",1));
		nM2JYS.put("PB", getADMap(sqJYSSt,"铅",5));
		nM2JYS.put("RB", getADMap(sqJYSSt,"螺纹钢",10));
		nM2JYS.put("RU", getADMap(sqJYSSt,"橡胶",10));
		nM2JYS.put("SN", getADMap(sqJYSSt,"沪锡",1));
		nM2JYS.put("WR", getADMap(sqJYSSt,"线材",10));
		nM2JYS.put("ZN", getADMap(sqJYSSt,"锌",5));
		//大商
		nM2JYS.put("A", getADMap(dsJYSSt,"豆一",10));
		nM2JYS.put("B", getADMap(dsJYSSt,"豆二",10));
		nM2JYS.put("BB", getADMap(dsJYSSt,"胶合板",500));
		nM2JYS.put("C", getADMap(dsJYSSt,"玉米",10));
		nM2JYS.put("CS", getADMap(dsJYSSt,"淀粉",10));
		nM2JYS.put("FB", getADMap(dsJYSSt,"纤维板",500));
		nM2JYS.put("I", getADMap(dsJYSSt,"铁矿石",100));
		nM2JYS.put("J", getADMap(dsJYSSt,"焦炭",100));
		nM2JYS.put("JM", getADMap(dsJYSSt,"焦煤",60));
		nM2JYS.put("JD", getADMap(dsJYSSt,"鸡蛋",10));
		nM2JYS.put("L", getADMap(dsJYSSt,"聚乙烯",5));
		nM2JYS.put("M", getADMap(dsJYSSt,"豆粕",10));
		nM2JYS.put("PP", getADMap(dsJYSSt,"聚丙烯",5));
		nM2JYS.put("P", getADMap(dsJYSSt,"棕榈油",10));
		nM2JYS.put("V", getADMap(dsJYSSt,"PVC",5));
		nM2JYS.put("Y", getADMap(dsJYSSt,"豆油",10));
		//郑商所
		nM2JYS.put("CF", getADMap(zsJYSSt,"棉花",5));
		nM2JYS.put("FG", getADMap(zsJYSSt,"玻璃",20));
		nM2JYS.put("JR", getADMap(zsJYSSt,"粳稻",20));
		nM2JYS.put("LR", getADMap(zsJYSSt,"晚秈稻",20));
		nM2JYS.put("MA", getADMap(zsJYSSt,"郑醇",10));
		nM2JYS.put("OI", getADMap(zsJYSSt,"菜油",10));
		nM2JYS.put("PM", getADMap(zsJYSSt,"普麦",50));
		nM2JYS.put("RS", getADMap(zsJYSSt,"油菜籽",10));
		nM2JYS.put("RM", getADMap(zsJYSSt,"菜籽粕",10));
		nM2JYS.put("RI", getADMap(zsJYSSt,"早稻",20));
		nM2JYS.put("SR", getADMap(zsJYSSt,"白糖",10));
		nM2JYS.put("SF", getADMap(zsJYSSt,"矽铁",5));
		nM2JYS.put("SM", getADMap(zsJYSSt,"锰硅",5));
		nM2JYS.put("TA", getADMap(zsJYSSt,"PTA",5));
		nM2JYS.put("WH", getADMap(zsJYSSt,"强麦",20));
		nM2JYS.put("ZC", getADMap(zsJYSSt,"动力煤",100));
	}
	private static Map<String, Object> getADMap(String jys, String name,
			int hycs) {
		Map<String, Object>  map = new HashMap<String, Object>(3);
		map.put("jys", jys);
		map.put("name", name);
		map.put("hycs", hycs);//合约乘数
		return map;
	}
	//====================================================
	/**
	 * @param args
	 *            author:xumin 2016-12-20 下午4:21:29
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		String str = getTempData();
		System.err.println(str);
		
//		System.err.println(DateUtil.string2Long("2016-05-26 01:00:00"));//1464195600000

		//		for(int i=0;i<20;i++){
//			System.err.println(getRandom(18.76));
//		}
		
	}

	private static String getTempData() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>(6);

		Map<String, Object> history = new HashMap<String, Object>(6);
		map.put("history", history);// ---------->一级菜单
		history.put("todayOpenPrice", 2002.3);// 开盘
		List<Map<String, Object>> items = new ArrayList<Map<String, Object>>(59);
		history.put("items", items);
		
		for(int i=0;i<1;i++){
			Map<String, Object> item = new HashMap<String, Object>(12);
			item.put("ma5", getRandom(2132.20));
			item.put("ma10", getRandom(2132.30));
			item.put("ma20", getRandom(2132.50));
	
			item.put("open", getRandom(2162.30));
			item.put("high", getRandom(2232.20));
			item.put("low",  getRandom(2062.10));
			item.put("close", getRandom(2162.10));
	
			item.put("volume",getRandom(208888));
	
			items.add(item);
		}
		// ======================================
		Map<String, Object> today = new HashMap<String, Object>(8);
		map.put("today", today);// ---------->一级菜单

		today.put("preClosePrice", 2002.3);// 昨收
		today.put("macdName", "MACD(12,26,9)");// 名字

		items = new ArrayList<Map<String, Object>>(300);
		today.put("items", items);
		
		long time = 1464195600000l;
		for(int i=0;i<1;i++){
			Map<String, Object> item = new HashMap<String, Object>(12);
			item.put("ma", getRandom(2084.20));// 均价
			item.put("closePrice", getRandom(2084.20));// 价格
			item.put("chg", getRandom(0.45));// 涨跌幅
			item.put("volatility", getRandom(1.45));// 振幅

			item.put("macd", getRandom(8.5));// macd纵坐标
			item.put("diff", getRandom(1.5));// 变化快的线
			item.put("dea", getRandom(-0.7));// EMA diff 9后的线

			item.put("volume", getRandom(12345));
			item.put("timestamp", time+60000*i);

			items.add(item);

		}
		
		String str = JSON.toJSONString(map);//JsonUtil.ObToJson(map);
		return str;
	}

	private static Object getRandom(double d) {
		int flag = random.nextInt(10);
		double tD = (d*random.nextInt(10))/100;
		if(flag%2==0){
			tD = tD*1.0;
		}else{
			tD = tD*-1.0;
		}
		double t = d+tD;
		return XiaoTHelp.get2Point(t);
	}

	/**
	 * 
	 * @param item
	 * @param market
	 * @param listMapMin
	 *            200跟线以上的分钟线 author:xumin 2016-12-20 下午8:17:21
	 * @param mapTar 
	 */
	public static int getJsonData(List<Map<String, Object>> listMapDay,
								  TQuestions item, int market, List<Map<String, Object>> listMapMin, Map<String, Object> mapTar) {
		int flag = 0;
		try {
			setHisDayData(mapTar,listMapDay);
			setHisMinData(mapTar,listMapMin,listMapDay);
		} catch (Exception e) {
			flag = -1;
			e.printStackTrace();
		}
		return flag;
	}
	//----------------------------------------------------------------------------------
	private static void setHisMinData(Map<String, Object> mapTar,
			List<Map<String, Object>> listMapMin, List<Map<String, Object>> listMapDay) {
		Map<String, Object> today = new HashMap<String, Object>(8);
		mapTar.put("today", today);// ---------->一级菜单
		double preClosePrice = (double) listMapDay.get(1).get("CLOSE_PRICE");//昨收
		today.put("preClosePrice", preClosePrice);// 昨收
		today.put("macdName", "MACD(12,26,9)");// 名字
		int size = listMapMin.size();
		List<Map<String, Object>> items = new ArrayList<Map<String, Object>>(size);
		today.put("items", items);
		
		emaShort = new ArrayList<>(size);
		emaLone = new ArrayList<>(size);
		emaDea = new ArrayList<>(size);
		double maxClose=0,minClose=0;
		for(int i=0;i<size;i++){
			Map<String, Object> item = getMinItem(i,listMapMin,items,preClosePrice);//获取了最早一个点的历史比如60
			double closePrice = (double) item.get("closePrice");
			if(i==0){
				maxClose = closePrice;
				minClose = closePrice;
			}else{
				if(maxClose<closePrice)
					maxClose = closePrice;
				if(minClose>closePrice)
					minClose = closePrice;
			}
			double volatility = (maxClose-minClose)*100.00/preClosePrice;
			item.put("volatility", XiaoTHelp.get2Point(volatility));// 振幅 (目前最高-目前最低)/昨收价 *100
			
			items.add(item);
		}
	}

	private static Map<String, Object> getMinItem(int index,
			List<Map<String, Object>> listMapMin, List<Map<String, Object>> items, double preClosePrice) {
		
		Map<String, Object> minItem = listMapMin.get(index);
		Map<String, Object> item = new HashMap<String, Object>(12);
		String SYMBOL = minItem.get("SYMBOL").toString();
		SYMBOL = SYMBOL.split("\\.")[0].toUpperCase();//比如是A 大豆
		long TURNOVER = (long) minItem.get("TURNOVER");
		long TOTALVOLUME = (long) minItem.get("TOTALVOLUME");
		double closePrice = (double) minItem.get("CLOSE_PRICE");
		long volume = (long) minItem.get("VOLUME");
		String DATATIME = minItem.get("DATATIME").toString();
		long timestamp = 0;
		try {
			timestamp = DateUtil.string2Long(DATATIME);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		item.put("timestamp", timestamp);
		
		int hycs = (int) nM2JYS.get(SYMBOL).get("hycs");//合约乘数
		double ma = TURNOVER*1.0/TOTALVOLUME/hycs;
		item.put("ma", XiaoTHelp.get2Point(ma));// 均价
		item.put("closePrice", closePrice);// 价格
		item.put("volume", volume);
		
		double chg = (closePrice/preClosePrice-1)*100;
		item.put("chg", XiaoTHelp.get2Point(chg));// 涨跌幅,最新收盘价/昨收价-1

		double diff = EMA(index,closePrice,12,emaShort) - EMA(index,closePrice,26,emaLone);
		item.put("diff", XiaoTHelp.get2Point(diff));// 变化快的线
		
		double dea = EMA(index,diff,9,emaDea);
		item.put("dea", XiaoTHelp.get2Point(dea));// EMA diff 9后的线
		
		double macd = 2*(diff-dea);
		item.put("macd",  XiaoTHelp.get2Point(macd));// macd纵坐标
		
		return item;
	}
	/**
	 * 
	 * @param index
	 * @param closePrice
	 * @param gene 因子  12 26 9
	 * @param emalist 记录前者ema的辅助内存
	 * @return
	 * author:xumin 
	 * 2016-12-21 下午5:47:21
	 */
	private static double EMA(int index, double closePrice, int gene, List<Double> emalist) {
		double ema = 0;
		if(index==0){
			ema = closePrice;
		}else{
			double preEMA = emalist.get(index-1);
			ema = preEMA*(gene-1)/(gene+1)+closePrice*2/(gene+1);
		}
		emalist.add(ema);
		return ema;
	}

	//------------------------------------------------------------------
	private static void setHisDayData(Map<String, Object> mapTar,
			List<Map<String, Object>> listMapDay) {
		Map<String, Object> history = new HashMap<String, Object>(3);
		mapTar.put("history", history);// ---------->一级菜单
		double todayOpenPrice = (double) listMapDay.get(0).get("OPEN_PRICE");
		history.put("todayOpenPrice", todayOpenPrice);// 当日开盘价格
		List<Map<String, Object>> items = new ArrayList<Map<String, Object>>(59);
		history.put("items", items);
		//处理后list第一个节点是最老的数据
		for(int i=1;i<60;i++){
			Map<String, Object> item = getHistoryItem(60-i,listMapDay);//获取了最早一个点的历史比如60
			items.add(item);
		}
	}
	/**
	 * 
	 * @param index 包括今天在内，往前数N天的下标 n-1
	 * @param listMapDay
	 * @return
	 * author:xumin 
	 * 2016-12-21 下午2:23:10
	 */
	private static Map<String, Object> getHistoryItem(int index,
			List<Map<String, Object>> listMapDay) {
		
		Map<String, Object> item = new HashMap<String, Object>(10);
		
		Map<String, Object> hisToday = listMapDay.get(index);//历史今天
		double high = (double) hisToday.get("HIGH_PRICE");
		double open = (double) hisToday.get("OPEN_PRICE");
		double low = (double) hisToday.get("LOW_PRICE");
		double close = (double) hisToday.get("CLOSE_PRICE");
		
		long volume = (long) hisToday.get("VOLUME");
		double ma5 =0,ma10=0,ma20=0,closeTotal=0;
		for(int i=index;i<(index+20);i++){
			Map<String, Object>  temp = listMapDay.get(i);
			double closeTemp = (double) temp.get("CLOSE_PRICE");
			closeTotal +=closeTemp;
			if(i-index==4){
				ma5 = closeTotal/5;
			}
			if(i-index==9){
				ma10 = closeTotal/10;
			}
			if(i-index==19){
				ma20 = closeTotal/20;
			}
		}
		//------------------
		item.put("high", high);
		item.put("open", open);
		item.put("low", low);
		item.put("close", close);
		
		item.put("volume", volume);
		item.put("ma5", XiaoTHelp.get2Point(ma5));
		item.put("ma10", XiaoTHelp.get2Point(ma10));
		item.put("ma20", XiaoTHelp.get2Point(ma20));
		
		return item;
	}
	//------------------------------------------------------------------
	public static String getRealCode(String symbolCode, Map<String, Object> symbolItem) {
		String jys = symbolItem.get("jys").toString();//交易所
		if(jys.equals("SHF") || jys.equals("DCE"))
			return symbolCode.toLowerCase();//这个小写要,上期+大商
		return symbolCode.toUpperCase();
	}

}
