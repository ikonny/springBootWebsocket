package cn.hkfdt.xiaot.websocket.service;

import java.util.Map;

public interface MatchService {
	/**
	 * 
	 * @param paraMap
	 * @return
	 * author:xumin 
	 * 2017-1-11 上午10:06:54
	 */
	String getMatch(Map<String, Object> paraMap);
	/**
	 * 
	 * @param paraMap sessionId,matchId
	 * @return -2 比赛不存在， -1比赛人数已满 ，0：准备成功 ,1:准备成功+可以通知开始 
	 * author:xumin 
	 * 2017-1-11 上午11:15:28
	 */
	int ready(Map<String, Object> paraMap);
	/**
	 * 
	 * @param paraMap {curIdx, yieldRate, tradeCount, drawOption,matchId,directInfo},sessionId
	 * author:xumin 
	 * 2017-1-11 下午1:00:11
	 */
	void sendClientMatchInfo(Map<String, Object> paraMap);

}
