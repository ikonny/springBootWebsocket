package cn.hkfdt.xiaot.websocket.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import cn.hkfdt.xiaot.websocket.utils.HttpUtils;

public class MatchServiceHelper {
	/**
	 * matchId 为key 
	 * matchJson,num,matchPeople(map),createTime,readyTime,rankList(最新的排序成绩)
	 * matchPeople : fdtId为key : {curIdx, yieldRate, tradeCount, markAreaData, fdtId,nickName}
	 * rankList : listMap 对matchPeople 中的排序
	 */
	public static ConcurrentHashMap<String, Map<String, Object>> mapMatchInfo = new ConcurrentHashMap<>(36);
	public static final String xiaotTrainingUrl = "https://prod.forexmaster.cn/im/xiaotTraining";
	public static ExecutorService executorService = Executors.newCachedThreadPool();
	public static LinkedBlockingQueue<String>  rankQueue = new LinkedBlockingQueue<>(87);
	public static volatile Map<String, Object> rankMapHelper = new HashMap<String, Object>(100);
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
						System.err.println("消费消息"+matchId);
						Map<String, Object>  mapItem = mapMatchInfo.get(matchId);
						//进行排序---------------------------
						Map<String, Object> matchPeople = (Map<String, Object>) mapItem.get("matchPeople");
						//rankList
						List<Map<String, Object>> rankList = new ArrayList<Map<String,Object>>(matchPeople.size());
						for(String key : matchPeople.keySet()){
							Map<String, Object> paraMap = (Map<String, Object>) matchPeople.get(key);
							rankList.add(paraMap);
						}
						sort(rankList);
//						mapItem.put(key, value);
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
//		String sessionId = paraMap.get("sessionId").toString();
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
		String matchId = paraMap.get("paraMap").toString();
		String sessionId = paraMap.get("sessionId").toString();
		Map<String, Object>  mapItem = mapMatchInfo.get(matchId);
		if(mapItem==null)
			return -2;
		Map<String, Object> matchPeople = (Map<String, Object>) mapItem.get("matchPeople");
		int numP = Integer.parseInt(mapItem.get("num").toString());
		if(matchPeople.size()==numP){
			//比赛已经开始，人数已经满了
			return -1;
		}
		matchPeople.put(sessionId, 1);//准备一个，入队列
		if(matchPeople.size()==numP){
			//start
			mapItem.put("readyTime", System.currentTimeMillis());
			return 1;
		}
		return 0;
	}
	public static void rankList(Map<String, Object> paraMap) {
		// TODO Auto-generated method stub
		String matchId = paraMap.get("matchId").toString();
		String sessionId = paraMap.get("sessionId").toString();
		Map<String, Object>  mapItem = mapMatchInfo.get(matchId);
		if(mapItem==null){
			System.err.println("获取不到比赛");
			return;
		}
		Map<String, Object> matchPeople = (Map<String, Object>) mapItem.get("matchPeople");
		Map<String, Object> mapPeople = new HashMap<String, Object>(6);
		setInfoForPerson(mapPeople,paraMap);
		matchPeople.put(sessionId, mapPeople);//准备一个，入队列
		
		if(!rankMapHelper.containsKey(matchId)){
			rankMapHelper.put(matchId, 1);
			rankQueue.add(matchId);//发排序事件，需要这个线程去排序
		}
	}
	private static void setInfoForPerson(Map<String, Object> mapPeople,
			Map<String, Object> paraMap) {
		// TODO Auto-generated method stub
		mapPeople.put("yieldRate", paraMap.get("yieldRate"));//收益率
		mapPeople.put("curIdx", paraMap.get("curIdx"));//交易点
		mapPeople.put("tradeCount", paraMap.get("tradeCount"));//交易次数
		mapPeople.put("markAreaData", paraMap.get("markAreaData"));
		
	}

}
