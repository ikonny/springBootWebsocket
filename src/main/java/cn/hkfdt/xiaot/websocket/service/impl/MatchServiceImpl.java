package cn.hkfdt.xiaot.websocket.service.impl;

import cn.hkfdt.xiaot.common.beans.ReqCommonBean;
import cn.hkfdt.xiaot.web.xiaot.service.XiaoTService;
import cn.hkfdt.xiaot.websocket.Beans.GameRuntimeBean;
import cn.hkfdt.xiaot.websocket.service.GameService;
import cn.hkfdt.xiaot.websocket.topic.XiaoTMatchTopics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static cn.hkfdt.xiaot.websocket.service.impl.MatchServiceHelper.cacheMapXM;

@Service
public class MatchServiceImpl implements GameService {

	@Autowired
	XiaoTMatchTopics xiaoTMatchTopics;
	@Autowired
	XiaoTService xiaoTService;

	//==================================================================
	
	@Override
	public int ready(ReqCommonBean reqCommonBean) {
		final String gameId = reqCommonBean.data.get("gameId").toString();
		int flag;
		synchronized(gameId){
			flag = MatchServiceHelper.ready(reqCommonBean);
		}
		return flag;
	}
	@Override
	public int gameStart(ReqCommonBean reqCommonBean) {
		//{"action":"go","gameId":"adsffgcsdf"}
		String gameId = reqCommonBean.data.get("gameId").toString();
		GameRuntimeBean gameRuntimeBean = (GameRuntimeBean) cacheMapXM.get(gameId);
		if(gameRuntimeBean.canJoinGame()){
			return -1;
		}
		cacheMapXM.put(gameId,gameRuntimeBean,60*5);//开始后调整时间
		xiaoTMatchTopics.start(gameId);
		return 0;
	}

	@Override
	public void sendClientMatchInfo(ReqCommonBean reqCommonBean) {
		MatchServiceHelper.sendClientMatchInfo(reqCommonBean);
	}



}
