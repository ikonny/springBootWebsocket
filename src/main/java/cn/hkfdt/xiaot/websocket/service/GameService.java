package cn.hkfdt.xiaot.websocket.service;

import cn.hkfdt.xiaot.common.beans.ReqCommonBean;

public interface GameService {
	/**
	 * @param reqCommonBean
	 * @return -2 比赛不存在， -1比赛人数已满 ，0：准备成功 ,1:准备成功+可以通知开始 
	 * author:xumin 
	 * 2017-1-11 上午11:15:28
	 */
	int ready(ReqCommonBean reqCommonBean);
	/**
	 * 
	 * @param reqCommonBean { curIdx: 1, gameId: '', userId: '',actions: [],returnRate: ''}
	 * author:xumin 
	 * 2017-1-11 下午1:00:11
	 */
	void sendClientMatchInfo(ReqCommonBean reqCommonBean);

	/**
	 *
	 * @param reqCommonBean
	 * @return 0启动成功  -1：人数没有满
	 */
	int gameStart(ReqCommonBean reqCommonBean);
}
