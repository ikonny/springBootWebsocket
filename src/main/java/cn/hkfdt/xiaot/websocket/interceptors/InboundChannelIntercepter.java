package cn.hkfdt.xiaot.websocket.interceptors;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.MessageHeaderAccessor;

public class InboundChannelIntercepter extends ChannelInterceptorAdapter {

	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		//即将进入业务层处理的消息
		StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
		if(StompCommand.SEND==accessor.getCommand()){
			byte[] bytes = (byte[]) message.getPayload();
			String msg = new String(bytes);
			System.out.println("收到消息:"+msg);
		}
//		if(StompCommand.CONNECT==accessor.getCommand()){
//			//连接的请求包
//		}
//		System.err.println(accessor.getHeartbeat());
		return message;
	}


}
