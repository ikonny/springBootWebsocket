package cn.hkfdt.xiaot.websocket.topic;

import cn.hkfdt.xiaot.common.beans.RspCommonBean;
import cn.hkfdt.xiaot.websocket.Beans.GameUserExtBean;
import cn.hkfdt.xiaot.websocket.Beans.GameUserListBean;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * 对客户端订阅的事件作出回应
 */
@Component
public class XiaoTMatchTopicsSub {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	private static Logger logger = LoggerFactory.getLogger(XiaoTMatchTopicsSub.class);
	/**
	 * @param args
	 * author:xumin 
	 * 2017-1-10 下午4:57:16
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<GameUserExtBean> rankList = new ArrayList<>(2);
		GameUserExtBean item = new GameUserExtBean();
		item.returnRate = 2;
		item.gameId = "123";
		item.userType=1;
		item.userName="李雷";
		item.curIdx=1;
		item.headimgurl="https://df";
		item.userId="sf";
		rankList.add(item);

		item = new GameUserExtBean();
		item.returnRate = 1.2;
		item.gameId = "123";
		item.userType=1;
		item.userName="是否";
		item.curIdx=1;
		item.headimgurl="https://df";
		item.userId="sf";
		rankList.add(item);

		List<GameUserListBean> listTar = new ArrayList<>(rankList.size());
		rankList.forEach(itemT->{
			GameUserListBean itemTemp = new GameUserListBean();
			itemTemp.userId = itemT.userId;
//			itemTemp.headimgurl = itemT.headimgurl;
//			itemTemp.userName = itemT.userName;
//			itemTemp.userType = itemT.userType;
//			itemTemp.returnRate = itemT.returnRate;
			listTar.add(itemTemp);
		});
		RspCommonBean rspCommonBean = RspCommonBean.getCommonRspBean(200,null);
		rspCommonBean.data = listTar;
		String str = JSON.toJSONString(rspCommonBean);
//		System.out.println("send rankList: " + str);
		System.err.println(str);
	}
	//====================================================================
	@SubscribeMapping("/monitor")
	public void start(Principal p) {
		String user = p.getName();
		simpMessagingTemplate.convertAndSendToUser(user, "/monitor", "dfs");
	}
	@SubscribeMapping("/monitor")
	public void init(SimpMessageHeaderAccessor accessor) {
		String user = accessor.getFirstNativeHeader("userid");
		simpMessagingTemplate.convertAndSendToUser(user, "/monitor", "dfs");
	}
}
