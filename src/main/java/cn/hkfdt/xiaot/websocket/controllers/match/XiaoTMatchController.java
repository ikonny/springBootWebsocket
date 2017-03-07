package cn.hkfdt.xiaot.websocket.controllers.match;

import cn.hkfdt.xiaot.common.beans.ReqCommonBean;
import cn.hkfdt.xiaot.common.beans.RspCommonBean;
import cn.hkfdt.xiaot.websocket.Beans.GameRuntimeBean;
import cn.hkfdt.xiaot.websocket.conmng.WebSocketConnectionListener;
import cn.hkfdt.xiaot.websocket.service.GameService;
import cn.hkfdt.xiaot.websocket.service.impl.MatchServiceHelper;
import cn.hkfdt.xiaot.websocket.topic.XiaoTMatchTopics;
import cn.hkfdt.xiaot.websocket.utils.GameUrlHelp;
import com.alibaba.fastjson.JSON;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
public class XiaoTMatchController {

	@Autowired
	GameService gameService;
	@Autowired
	XiaoTMatchTopics xiaoTMatchTopics;

	private static org.slf4j.Logger logger = LoggerFactory.getLogger(XiaoTMatchController.class);
	
	public static void main(String[] args){
		Map<String, Object>  map = new HashMap<String, Object>();
		map.put("rspCode", 200);
//		map.put("msg", "只有rspCode不为200的时候有错误，有这个属性");
		String str = JSON.toJSONString(map);
		System.err.println(str);
	}
	//==================================================
	/**
	 * 把jaon转化成map 并增加sessionId,fdtId
	 * @param headerAccessor
	 * @param msg
	 * @return
	 * author:xumin 
	 * 2017-1-11 下午3:42:36
	 */
	@SuppressWarnings("unchecked")
	public static ReqCommonBean getParaMap(SimpMessageHeaderAccessor headerAccessor, String msg) {
		Map<String, Object> tar = JSON.parseObject(msg);
		String sessionId = headerAccessor.getSessionId(); // Session ID
		String fdtId = WebSocketConnectionListener.mapSession2FdtId.get(sessionId);

		ReqCommonBean reqCommonBean = new ReqCommonBean();
		reqCommonBean.sessionId = sessionId;
		reqCommonBean.data = tar;
		reqCommonBean.fdtId = fdtId;

		return reqCommonBean;
	}

	@MessageMapping(GameUrlHelp.queue_userDoReady)
	@SendToUser(GameUrlHelp.queue_userDoReady)
	public String ready(SimpMessageHeaderAccessor headerAccessor,String msg) {
		Map<String, Object>  paraMap = JSON.parseObject(msg);
		String userId = paraMap.get("userId").toString();
		String sessionId = headerAccessor.getSessionId(); // Session ID
		WebSocketConnectionListener.removeUserId(sessionId);
		WebSocketConnectionListener.setUserIds(userId,sessionId);//重建sessionId和userId对应关系

		ReqCommonBean reqCommonBean = new ReqCommonBean();
		reqCommonBean.sessionId = sessionId;
		reqCommonBean.data = paraMap;
		reqCommonBean.fdtId = userId;
		Map<String,Object>  mapTar = null;

		int flag = gameService.ready(reqCommonBean);
		String msg2 ="";
		int rspCode = 200;
		if(flag==-2){
			rspCode = 201;
			msg2 = "比赛不存在";
		}
		if(flag==-1){
			rspCode = 201;
			msg2 = "房间人数已满，不可加入比赛";
		}
		if(flag>=0){
			mapTar = new HashMap<>(1);
			String gameId = reqCommonBean.data.get("gameId").toString();
			GameRuntimeBean gameRuntimeBean = (GameRuntimeBean) MatchServiceHelper.cacheMapXM.get(gameId);
			mapTar.put("gameName",gameRuntimeBean.tGame.getGameName());
		}

		RspCommonBean rspCommonBean = RspCommonBean.getCommonRspBean(rspCode,msg2);
		rspCommonBean.data = mapTar;
		String str = JSON.toJSONString(rspCommonBean);
		return str;
	}
	@MessageMapping(GameUrlHelp.queue_gameStart)
	@SendToUser(GameUrlHelp.queue_gameStart)
	public String gameStart(SimpMessageHeaderAccessor headerAccessor,String msg) {
		ReqCommonBean reqCommonBean = getParaMap(headerAccessor,msg);
		int flag = gameService.gameStart(reqCommonBean);
		String msg2 ="";
		int rspCode = 200;
//		if(flag==-1){
//			msg2="人数未满";
//			rspCode = 201;
//		}
		if(flag==-2){
			msg2="比赛超时回收";
			rspCode = 202;
		}
		RspCommonBean rspCommonBean = RspCommonBean.getCommonRspBean(rspCode,msg2);
		String str = JSON.toJSONString(rspCommonBean);
		return str;
	}
	
	
	@MessageMapping(GameUrlHelp.queue_gameclientInfo)
	public void sendClientMatchInfo(SimpMessageHeaderAccessor headerAccessor,String msg) {
		ReqCommonBean reqCommonBean = getParaMap(headerAccessor,msg);
		gameService.sendClientMatchInfo(reqCommonBean);
	}
	//比赛结束，主动，入库，回收资源
	@MessageMapping(GameUrlHelp.queue_gameOver)
	@SendToUser(GameUrlHelp.queue_gameOver)
	public String gameOver(SimpMessageHeaderAccessor headerAccessor,String msg) {
		ReqCommonBean reqCommonBean = getParaMap(headerAccessor,msg);
		int flag = gameService.gameEnd(reqCommonBean);
		RspCommonBean rspCommonBean = RspCommonBean.getCommonRspBean(200,null);
		if(flag==-1){
			rspCommonBean.rspCode = 201;
			rspCommonBean.msg = "异常结束";
		}
		String str = JSON.toJSONString(rspCommonBean);
		return str;
	}

}
