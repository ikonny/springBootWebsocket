package cn.hkfdt.xiaot.websocket.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.GenericMessage;

public class OutboundChannelIntercepter extends ChannelInterceptorAdapter {

	static Logger logger = LoggerFactory.getLogger("inAndOut");

	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		//即将进入业务层处理的消息
		if(message!=null){
			GenericMessage genericMessage = (GenericMessage) message;
			String msgType = genericMessage.getHeaders().get("simpMessageType").toString();
			if(msgType.equals("MESSAGE")) {
				byte[] bytes = (byte[]) message.getPayload();
//				logger.info("-----------size:"+bytes.length);
				String msg = new String(bytes);
				String des = genericMessage.getHeaders().get("simpDestination").toString();
				logger.info("<<<<<<<<====="+des+" : "+msg);
			}
		}
//		if(StompCommand.CONNECT==accessor.getCommand()){
//			//连接的请求包
//		}
//		System.err.println(accessor.getHeartbeat());
		return message;
	}
}
