package cn.hkfdt.xiaot.websocket.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.MessageHeaderAccessor;

public class OutboundChannelIntercepter extends ChannelInterceptorAdapter {

	static Logger logger = LoggerFactory.getLogger(OutboundChannelIntercepter.class);

	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		//即将进入业务层处理的消息
		StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
		if(accessor!=null && StompCommand.SEND==accessor.getCommand()){
			byte[] bytes = (byte[]) message.getPayload();
			String msg = new String(bytes);
			System.out.println("out__消息:"+msg);
		}
//		if(StompCommand.CONNECT==accessor.getCommand()){
//			//连接的请求包
//		}
//		System.err.println(accessor.getHeartbeat());
		return message;
	}

	public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
		logger.info("postSend");
		StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
		if(accessor!=null && StompCommand.SEND==accessor.getCommand()){
			byte[] bytes = (byte[]) message.getPayload();
			String msg = new String(bytes);
			System.out.println("out__消息:"+msg);
		}
	}

	public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
		logger.info("afterSendCompletion");
		StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
		if(accessor!=null && StompCommand.SEND==accessor.getCommand()){
			byte[] bytes = (byte[]) message.getPayload();
			String msg = new String(bytes);
			System.out.println("out__消息:"+msg);
		}
	}

	public boolean preReceive(MessageChannel channel) {
		logger.info("preReceive");
		return true;
	}

	public Message<?> postReceive(Message<?> message, MessageChannel channel) {
		logger.info("postReceive");
		return message;
	}

	public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {
		logger.info("afterReceiveCompletion");
	}

}
