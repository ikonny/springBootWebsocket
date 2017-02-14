package cn.hkfdt.xiaot.web.xiaot.service.impl;

import cn.hkfdt.xiaot.mybatis.mapper.ltschina.ForceAnalysisExtendsMapper;
import cn.hkfdt.xiaot.mybatis.mapper.ltschina.SchoolMapper;
import cn.hkfdt.xiaot.mybatis.mapper.ltschina.TQuestionsExtendsMapper;
import cn.hkfdt.xiaot.mybatis.mapper.ltschina.TRecordExtendsMapper;
import cn.hkfdt.xiaot.mybatis.model.ltschina.*;
import cn.hkfdt.xiaot.util.ImageUtil;
import cn.hkfdt.xiaot.web.common.redis.RedisClient;
import cn.hkfdt.xiaot.web.common.service.AuthService;
import cn.hkfdt.xiaot.web.xiaot.service.XiaoTService;
import cn.hkfdt.xiaot.web.xiaot.service.md.XiaoTJdbcDriver;
import cn.hkfdt.xiaot.web.xiaot.service.md.XiaoTMDDBHelper;
import cn.hkfdt.xiaot.web.xiaot.service.md.XiaoTMDHelp;
import cn.hkfdt.xiaot.web.xiaot.util.XiaoTMarketType;
import cn.hkfdt.xiaot.web.xiaot.util.YSUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * author:xumin 
 * 2016-12-15 下午4:12:42
 */
@Service
public class XiaoTServiceImpl implements XiaoTService {

	@Autowired
    JdbcTemplate jdbcTemplate;
	@Autowired
	ForceAnalysisExtendsMapper forceAnalysisExtendsMapper;
	@Autowired
	TQuestionsExtendsMapper tQuestionsExtendsMapper;
	@Autowired
	TRecordExtendsMapper tRecordExtendsMapper;
	@Autowired
	AuthService authService;
	@Autowired
	SchoolMapper schoolMapper;
	
	
	AtomicBoolean isInitingTQ = new AtomicBoolean(false);
	private static final int tryNum = 3;//重试次数
	
	//=====================================
	 @PostConstruct
	public void init(){
	 	try {
			XiaoTMDDBHelper.jdbcTemplate = jdbcTemplate;
			XiaoTHelp.init(jdbcTemplate);//初始化一些配置信息
		}catch (Exception e){
	 		e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public ForceAnalysis getXiaotForceAnalysis(String fdtId, int market) {
		ForceAnalysis item = new ForceAnalysis();
		item.setFdtId(fdtId);
		item.setType(market);
		return forceAnalysisExtendsMapper.selectByFdtId(item);
	}

	@Override
	public int getXiaotRecord(Map<String, Object>  mapPara, Map<String, Object> mapTar) {
		List<TRecord> listItem =  tRecordExtendsMapper.getXiaotRecord(mapPara);
		int offset = (int) mapPara.get("offset");
		int count = (int) mapPara.get("count");
//		String fdtId = mapPara.get("fdtId").toString();
//		int market = (int) mapPara.get("market");
		int total = tRecordExtendsMapper.getXiaotRecordTotal(mapPara);
		
		mapTar.put("total", total);
		mapTar.put("offset", offset);
		mapTar.put("count", count);
		mapTar.put("status", 200);
		List<Map<String, Object>>  data = new ArrayList<Map<String,Object>>(listItem.size());
		mapTar.put("data", data);
		for(TRecord item : listItem){
			Map<String, Object> itemTemp = new HashMap<String, Object>(6);
			data.add(itemTemp);
			String symbolCode = item.getSymbol().toUpperCase();//A
			Map<String, Object> symbolItem = XiaoTMDHelp.nM2JYS.get(symbolCode);
			if(symbolItem!=null){
				String rCode = XiaoTMDHelp.getRealCode(symbolCode,symbolItem);
				String chinaName = symbolItem.get("name").toString();
				itemTemp.put("symbolName", chinaName);
				itemTemp.put("symbolCode", rCode);
			}
			itemTemp.put("tradeTime", item.getTradeTime());
			itemTemp.put("returnRate", item.getReturnRate());
			itemTemp.put("volatility", item.getVolatility());
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getXiaotMasterList(int market,boolean isflush) {
		List<Map<String, Object>> listTar = null;
		String key = "getXiaotMasterList_" + market;
		listTar = (List<Map<String, Object>>) RedisClient.getex(key);
//		boolean isflush = false;
        if (listTar != null && !isflush)
        	return listTar;
		//-------------------------------------------
		List<ForceAnalysis>  listFa = forceAnalysisExtendsMapper.getXiaotMasterList(market);
		if(listFa==null || listFa.isEmpty())
			return null;
		//-------------------------
		List<String> listFdtId = new ArrayList<>(listFa.size());
		for(int i=0;i<listFa.size();i++){
			listFdtId.add(listFa.get(i).getFdtId());
		}
		ConcurrentHashMap<String,Map<String, Object>> fdtId2AuthExInfo = authService.getFdtId2AuthExInfo(listFdtId);
		//-----------------------------
		
		listTar = new ArrayList<Map<String,Object>>(listFa.size());
		for(ForceAnalysis item : listFa){
			try{
				Map<String, Object> mapItem = new HashMap<String, Object>(6);
				
				String fdtId = item.getFdtId();
				float fdtScore = item.getFdtScore();
				float accumulatedIncome = item.getAccumulatedIncome();
				mapItem.put("userId", fdtId);
				mapItem.put("score", fdtScore);
				mapItem.put("percent", accumulatedIncome);
				mapItem.put("tradeCount", item.getTradeCount());

				Map<String,Object> mapInfo = fdtId2AuthExInfo.get(fdtId);
				if(mapInfo==null)
					continue;
				if(!mapInfo.containsKey("auth"))
					continue;
				Auth authItem = (Auth) mapInfo.get("auth");
				String school = "";
				School scO = (School) mapInfo.get("school");
				if(scO!=null)
					school = scO.getScName();
				String username = authItem.getUsername();
				String servingUrl = authItem.getServingUrl();
//				servingUrl = DiscoverHelper.operPicURL(servingUrl);
				servingUrl = ImageUtil.transAndResizeImg(servingUrl,100,100);
				boolean isvip = (boolean) mapInfo.get("vip");
				mapItem.put("school", school);
				mapItem.put("name", username);
				mapItem.put("header_url", servingUrl);
				mapItem.put("isvip", isvip);
				
				listTar.add(mapItem);
			}catch(Exception e){
				e.printStackTrace();//防止个别数据出错影响整个排行
			}
		}
		//-------------------------------------
		RedisClient.setex(key, listTar, 60*5);
		return listTar;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int xiaotTraining(String fdtId, int market, Map<String, Object> mapTar) {
		TQuestions tQuestions = null;
		int count=0;
		while(tQuestions == null){
			TQuestions para = XiaoTHelp.getTQuestion(fdtId,market);
			tQuestions = tQuestionsExtendsMapper.getByUnionKey(para);
			++count;
			if(count>=tryNum){
				break;
			}
		}
		byte[] jsonData = tQuestions.getJsonData();
		try {
			//获取解压后的真实数据json
			jsonData = YSUtils.uncompress(jsonData);
			Map<String, Object> jsonDataMap = new HashMap<String, Object>(6);
			jsonDataMap = JSON.parseObject(new String(jsonData));//(Map<String, Object>) JsonUtil.JsonToOb(new String(jsonData), jsonDataMap.getClass());
			mapTar.put("jsonData",jsonDataMap );
			
			mapTar.put("key", XiaoTHelp.getTKey(tQuestions));
			mapTar.put("market", XiaoTHelp.getMarketCode(tQuestions));
			mapTar.put("fdtId", fdtId);
			
			String tradeTime = tQuestions.getTradeDay();
			mapTar.put("tradeTime", tradeTime.replace("-", "."));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int xiaotDoScore(final String fdtId, final String body,
			Map<String, Object> mapTar) {
		int count=0;
		Map<String, Object> tempMap = new HashMap<String, Object>(1);
		tempMap = JSON.parseObject(body);//(Map<String, Object>) JsonUtil.JsonToOb(body, tempMap.getClass());
		String[] strs = tempMap.get("key").toString().split("#");
		tempMap.put("exchangeCode", strs[0]);
		tempMap.put("symbol", strs[1]);
		tempMap.put("fdtId", fdtId);
		if(tempMap.containsKey("version")){
			XiaoTHelp.version = (int) tempMap.get("version");
		}
		mapTar.put("status", 200);
		while(count<=tryNum){
			Map<String, Object> temp = XiaoTHelp.xiaotDoScore(JSON.toJSONString(tempMap));
			if(temp!=null && !temp.isEmpty()){
				int code = (int) temp.get("code");
				if(code==200){
					double score = 0.0;
					if(temp.get("score")!=null)
						score = Double.parseDouble(temp.get("score").toString());
					boolean win = (boolean) temp.get("win");
					setXiaotDoScoreRtnMap(mapTar,score,tempMap,win);
					if(fdtId.equals(XiaoTHelp.xiaoTGuest))
						return 0;
					//---------登录用户才可以记录战绩---------------------
					TRecord record = new TRecord();
					BeanUtils.copyProperties(record, tempMap);
					record.setActions(tempMap.get("actions").toString());
					record.setQuestionKey(tempMap.get("key").toString());
					record.setCreateTime(System.currentTimeMillis());
					record.setScore(score);
					record.setVERSION(XiaoTHelp.version);//新数据需要加上
					tRecordExtendsMapper.insertSelective(record);
					//-----请求战力分析，并且更新数据库-----------
					Runnable run = new Runnable() {
						
						@Override
						public void run() {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							setxiaoTZL(fdtId,body);
						}
					};
					XiaoTHelp.executorService.execute(run);
					//----------------------------------------------
					return 0;
				}
			}
			++count;
			if(count>=tryNum){
				if(temp!=null && !temp.isEmpty()){
					String msg = temp.get("msg").toString();
					mapTar.put("msg", msg);
					return -2;
				}
				return -1;
			}
		}
		return 0;
	}
	//设置打分后的返回数据
	private void setXiaotDoScoreRtnMap(Map<String, Object> mapTar,
			double score, Map<String, Object> tempMap, boolean win) {
		String symbol = tempMap.get("symbol").toString();
		Map<String, Object> symbolItem = XiaoTMDHelp.nM2JYS.get(symbol);
		String chinaName = symbolItem.get("name").toString();
		String tradeTime = tempMap.get("tradeTime").toString();
		
		String returnRate = tempMap.get("returnRate").toString();
		String volatility = tempMap.get("volatility").toString();
		
		mapTar.put("score",XiaoTHelp.get2Point(score));
		mapTar.put("tradeTime", tradeTime);
		mapTar.put("symbolName", chinaName);
		mapTar.put("returnRate", returnRate);
		mapTar.put("volatility", volatility);
		mapTar.put("win", win);
		
	}

	/**
	 * 每次打分成功后，请求服务，更新战力分析数据到本数据库
	 * @param fdtId
	 * @param body
	 * author:xumin 
	 * 2016-12-19 下午4:07:39
	 */
	private void setxiaoTZL(String fdtId, String body) {
		int count=0;
		while(count<=tryNum){
			Map<String, Object> temp = XiaoTHelp.getXiaoTZL(fdtId,body);
			if(temp!=null && !temp.isEmpty()){
				int code = (int) temp.get("code");
				if(code==200){
					double fdtScore = Double.parseDouble(temp.get("score").toString());
					double accumulatedIncome =  Double.parseDouble(temp.get("accumulatedIncome").toString());
					int tradeCount = (int) temp.get("tradeCount");
					int winCount = (int) temp.get("winCount");
					double maxDrawDown = Double.parseDouble(temp.get("maxDrawDown").toString());
					double sharpeRatio = Double.parseDouble(temp.get("sharpeRatio").toString());
					
					ForceAnalysis record = new ForceAnalysis();
					record.setFdtScore(Float.parseFloat(XiaoTHelp.get2Point(fdtScore)));
					record.setAccumulatedIncome(Float.parseFloat(XiaoTHelp.get2Point(accumulatedIncome)));
					record.setFdtId(fdtId);
					record.setMaxDrawdown(Float.parseFloat(XiaoTHelp.get2Point(maxDrawDown)));
					record.setSharpeRatio(Float.parseFloat(XiaoTHelp.get2Point(sharpeRatio)));
					record.setTradeCount(tradeCount);
					record.setType(XiaoTMarketType.FC.getType());
					record.setWinCount(winCount);
					record.setCreateTime(System.currentTimeMillis());

					if(temp.containsKey("version")){
						int version = (int) temp.get("version");
						record.setVERSION(version);
					}

					ForceAnalysis tempAna = forceAnalysisExtendsMapper.selectByFdtId(record);
					if(tempAna==null)
						forceAnalysisExtendsMapper.insertSelective(record);
					else{
						record.setForceId(tempAna.getForceId());
						forceAnalysisExtendsMapper.updateByPrimaryKeySelective(record);
					}
					return;
				}
			}
			++count;
		}
	}

	
	//================================================================================
	@Override
	public int initTQuestions(final int market, Map<String, Object> mapTar) {
		if(isInitingTQ.get())
			return -1;//正在进行初始化数据
		isInitingTQ.set(true);
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				try{
					List<TQuestions> listQ = tQuestionsExtendsMapper.initTQuestions(market);
					for(TQuestions item : listQ){
						List<Map<String, Object>> listMapday = XiaoTMDDBHelper.getHistoryDayData(item,market);
						if(listMapday!=null && listMapday.size()==79){
							List<Map<String, Object>> listMapMin = XiaoTMDDBHelper.getHistoryMinData(item, market);
							if(listMapMin!=null && listMapMin.size()>=200){
								Map<String, Object>  mapTar = new HashMap<String, Object>(2);
								int flag = XiaoTMDHelp.getJsonData(listMapday,item,market,listMapMin,mapTar);
								if(flag==0){
									String jsonData = JSON.toJSONString(mapTar);//JsonUtil.ObToJson(mapTar);
									try {
										byte[] byteTar = YSUtils.compress(jsonData.getBytes(), 2);
										item.setJsonData(byteTar);
										item.setInitType(1);
									} catch (IOException e) {
										item.setInitType(-3);//为止原因之一
										e.printStackTrace();
									}
								}else{
									item.setInitType(-4);//计算失败
								}
							}else{
								//插入数据失败的标志
								item.setInitType(-2);//分钟线少于200
							}
						}else{
							//插入数据失败的标志
							item.setInitType(-1);//日行情少于79天
						}
						tQuestionsExtendsMapper.updateByPrimaryKeySelective(item);
					}
				}finally{
					XiaoTJdbcDriver.closeCon();
					isInitingTQ.set(false);
				}
			}
		};
		Thread td = new Thread(run);
		td.setName("初始化小T行情数据");
		td.start();
		return 0;
	}


}
