package cn.hkfdt.xiaot.websocket.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hkfdt.xiaot.websocket.service.MatchService;
import cn.hkfdt.xiaot.websocket.topic.XiaoTMatchTopics;

@Service
public class MatchServiceImpl implements MatchService{

	@Autowired
	XiaoTMatchTopics xiaoTMatchTopics;
	/**
	 * @param args
	 * author:xumin 
	 * 2017-1-10 下午10:15:54
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getMatch(Map<String, Object> paraMap) {
		String matchId = paraMap.get("matchId").toString();
		Map<String, Object> mapRsp = new HashMap<String, Object>(6);
		synchronized(matchId){
			MatchServiceHelper.getMatch(paraMap,mapRsp);
		}
		String matchJson = mapRsp.get("matchJson").toString();
		return matchJson;
	}
	@Override
	public int ready(Map<String, Object> paraMap) {
		final String matchId = paraMap.get("paraMap").toString();
		int flag = 0;
		synchronized(matchId){
			flag = MatchServiceHelper.ready(paraMap);
		}
		if(flag==1){
			//开线程去执行go命令
			Runnable run = new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					xiaoTMatchTopics.start(matchId);
				}
			};
			MatchServiceHelper.executorService.execute(run);
		}
		return flag;
	}

	@Override
	public void sendClientMatchInfo(Map<String, Object> paraMap) {
		// TODO Auto-generated method stub
		MatchServiceHelper.rankList(paraMap);
//		xiaoTMatchTopics.rankList(message);
//		xiaoTMatchTopics.userRealtimeInfo(message);
	}

}
