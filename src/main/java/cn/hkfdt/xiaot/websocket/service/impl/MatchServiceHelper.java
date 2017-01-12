package cn.hkfdt.xiaot.websocket.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import cn.hkfdt.xiaot.websocket.conmng.WebSocketConnectionListener;
import cn.hkfdt.xiaot.websocket.topic.XiaoTMatchTopics;
import cn.hkfdt.xiaot.websocket.utils.HttpUtils;

public class MatchServiceHelper {
	/**
	 * 主要的比赛对象，需要定时回收matchId 为key 
	 * matchJson,num,matchPeople(map),createTime,readyTime,rankList(最新的排序成绩)
	 * matchPeople : fdtId为key : {curIdx, yieldRate, tradeCount, drawOption, fdtId,nickName}
	 * rankList : listMap 对matchPeople 中的排序
	 */
	public static ConcurrentHashMap<String, Map<String, Object>> mapMatchInfo = new ConcurrentHashMap<>(66);
	public static final String xiaotTrainingUrl = "https://prod.forexmaster.cn/im/xiaotTraining";
	public static ExecutorService executorService = Executors.newCachedThreadPool();
	public static LinkedBlockingQueue<String>  rankQueue = new LinkedBlockingQueue<>(87);
	public static volatile Map<String, Object> rankMapHelper = new HashMap<String, Object>(100);
	public static XiaoTMatchTopics xiaoTMatchTopics = null;//被动注入的
	private static Logger logger = Logger.getLogger(WebSocketConnectionListener.class);
	/**
	 * @param args
	 * author:xumin 
	 * 2017-1-11 上午10:09:53
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> rankList = new ArrayList<Map<String,Object>>(3);
		Map<String, Object> item1 = new HashMap<String, Object>(2);
		item1.put("yieldRate", 1.2);
		item1.put("ssd", 1334);
		rankList.add(item1);
		
		item1 = new HashMap<String, Object>(2);
		item1.put("yieldRate", 2.2);
		item1.put("ssd", 11114);
		rankList.add(item1);
		
		item1 = new HashMap<String, Object>(2);
		item1.put("yieldRate", 0.2);
		item1.put("ssd", 1000);
		rankList.add(item1);
		
		sort(rankList);
		for(Map<String, Object> map : rankList)
			System.err.println(map);
		
	}
	static{
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						String matchId = rankQueue.take();
						rankMapHelper.remove(matchId);//消费一个排序
//						System.err.println("消费消息"+matchId);
						Map<String, Object>  mapItem = mapMatchInfo.get(matchId);
						//进行排序---------------------------
						Map<String, Object> matchPeople = (Map<String, Object>) mapItem.get("matchPeople");
						//rankList
						List<Map<String, Object>> rankList = new ArrayList<Map<String,Object>>(matchPeople.size());
						Iterator<String> iterator = matchPeople.keySet().iterator();
						while(iterator.hasNext()){
							String key = iterator.next();
//							System.out.println("key:"+key);
//							System.out.println("value:"+matchPeople.get(key));
							Object obTemp = matchPeople.get(key);
							if(obTemp instanceof HashMap<?, ?>){
								Map<String, Object> paraMap = (Map<String, Object>) matchPeople.get(key);
								rankList.add(paraMap);
							}
						}
						sort(rankList);
						mapItem.put("rankList", rankList);//排序完成
						//-----排序完成广播+用户数据全部更新事件----------
						sendToClientRankEvent(mapItem,rankList);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread td = new Thread(run);
		td.setName("游戏排行线程");
		td.start();
	}
	/**
	 * 定时器调用这个方法来回收比赛时间
	 * createTime,readyTime ()
	 * author:xumin 
	 * 2017-1-11 下午7:06:03
	 */
	public static void recoverMatchInfo() {
		long now = System.currentTimeMillis();
		for(String key : mapMatchInfo.keySet()){
			Map<String, Object> mapMatch = mapMatchInfo.get(key);
			if(mapMatch.containsKey("readyTime")){
				long readyTime = (long) mapMatch.get("readyTime");
				if((now-readyTime)>1000*60*7){
					//如果比赛开始，7分钟后的统一回收
					mapMatchInfo.remove(key);
				}
			}else{
				long createTime = (long) mapMatch.get("createTime");
				if((now-createTime)>1000*60*18){
					//如果比赛创建，18分钟后的统一回收
					mapMatchInfo.remove(key);
				}
			}
			
		}
	}
	//==============================================================
	/**
	 * 改方法在同步块中，同一场比赛同步
	 * @param paraMap 入参matchId sessionId num
	 * @param mapRsp  matchJson , isReady ,empty
	 * author:xumin 
	 * 2017-1-11 上午10:26:56
	 */
	public static void getMatch(Map<String, Object> paraMap, Map<String, Object> mapRsp) {
		String matchId = paraMap.get("matchId").toString();
		int num = Integer.parseInt(paraMap.get("num").toString());
		Map<String, Object>  mapItem = mapMatchInfo.get(matchId);
		if(mapItem==null){
			//1.如果比赛id没有就内存创建比赛，比赛id为key,后面是比赛信息，包括人数，参加人数，比赛题目。
			Map<String, Object> mapMatch = new HashMap<String, Object>(8);
			mapMatchInfo.put(matchId, mapMatch);
			mapMatch.put("num", num);
			
			String matchJson = HttpUtils.postJson(xiaotTrainingUrl, "");
			mapMatch.put("matchJson", matchJson);
			
			Map<String, Object> matchPeople = new HashMap<String, Object>(num);
			mapMatch.put("matchPeople", matchPeople);
			
			mapMatch.put("createTime", System.currentTimeMillis());
			
			mapRsp.put("matchJson", matchJson);
			
			logger.info("创建比赛_num:"+num+"matchId:"+matchId);
		}else{
			String matchJson = mapItem.get("matchJson").toString();
			mapRsp.put("matchJson", matchJson);
		}
	}
	//这个是降序
	protected static void sort(List<Map<String, Object>> rankList) {
		Collections.sort(rankList, new Comparator<Map<String, Object>>() {

			@Override
			public int compare(Map<String, Object> o1,
					Map<String, Object> o2) {
				double yieldRate1 = Double.parseDouble(o1.get("yieldRate").toString());
				double yieldRate2 = Double.parseDouble(o2.get("yieldRate").toString());
				if(yieldRate1>=yieldRate2)
					return -1;
				return 1;
			}
		});
	}
	/**
	 * 
	 * @param paraMap sessionId,matchId
	 * @return -2 比赛不存在， -1比赛人数已满 ，0：准备成功 ,1:准备成功+可以通知开始
	 * author:xumin 
	 * 2017-1-11 上午11:29:29
	 */
	@SuppressWarnings("unchecked")
	public static int ready(Map<String, Object> paraMap) {
		String matchId = paraMap.get("matchId").toString();
		String fdtId = paraMap.get("fdtId").toString();
		Map<String, Object>  mapItem = mapMatchInfo.get(matchId);
		if(mapItem==null)
			return -2;
		Map<String, Object> matchPeople = (Map<String, Object>) mapItem.get("matchPeople");
		int numP = Integer.parseInt(mapItem.get("num").toString());
		if(matchPeople.size()==numP){
			//比赛已经开始，人数已经满了
			return -1;
		}
		matchPeople.put(fdtId, 1);//准备一个，入队列
		logger.info("比赛matchId:"+matchId+"_num:"+numP+"__加入一人fdtId:"+fdtId);
		if(matchPeople.size()==numP){
			//start
			logger.info("比赛matchId:"+matchId+"_num:"+numP+"__人齐了");
			mapItem.put("readyTime", System.currentTimeMillis());
			return 1;
		}
		return 0;
	}
	public static void rankList(Map<String, Object> paraMap) {
		String matchId = paraMap.get("matchId").toString();
		String fdtId = paraMap.get("fdtId").toString();
		Map<String, Object>  mapItem = mapMatchInfo.get(matchId);
		if(mapItem==null){
			System.err.println("获取不到比赛");
			return;
		}
		Map<String, Object> matchPeople = (Map<String, Object>) mapItem.get("matchPeople");
		Map<String, Object> mapPeople = new HashMap<String, Object>(16);
		setInfoForPerson(mapPeople,paraMap);
		matchPeople.put(fdtId, mapPeople);//准备一个，入队列
		
		if(!rankMapHelper.containsKey(matchId)){
			rankMapHelper.put(matchId, 1);
			rankQueue.add(matchId);//发排序事件，需要这个线程去排序
		}
	}
	private static void setInfoForPerson(Map<String, Object> mapPeople,
			Map<String, Object> paraMap) {
		mapPeople.put("yieldRate", paraMap.get("yieldRate"));//收益率
		mapPeople.put("curIdx", paraMap.get("curIdx"));//交易点
		mapPeople.put("tradeCount", paraMap.get("tradeCount"));//交易次数
		mapPeople.put("drawOption", paraMap.get("drawOption"));
		mapPeople.put("fdtId", paraMap.get("fdtId"));//fdtId
		mapPeople.put("nickName", paraMap.get("fdtId"));//昵称
		
		mapPeople.put("preClosePrice", paraMap.get("preClosePrice"));//fdtId
		mapPeople.put("curClosePrice", paraMap.get("curClosePrice"));//fdtId
		mapPeople.put("curMa", paraMap.get("curMa"));//fdtId
		mapPeople.put("curVolume", paraMap.get("curVolume"));//fdtId
	}
	protected static void sendToClientRankEvent(Map<String, Object> mapItem,
			final List<Map<String, Object>> rankList) {
//		Runnable run = new Runnable() {
//			
//			@Override
//			public void run() {
//				xiaoTMatchTopics.rankList(rankList);
//				xiaoTMatchTopics.userRealtimeInfo(rankList);
//			}
//		};
//		MatchServiceHelper.executorService.execute(run);
		xiaoTMatchTopics.rankList(rankList);
		xiaoTMatchTopics.userRealtimeInfo(rankList);
	}

}
