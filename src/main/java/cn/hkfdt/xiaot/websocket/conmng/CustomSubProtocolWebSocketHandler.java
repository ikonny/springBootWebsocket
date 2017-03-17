package cn.hkfdt.xiaot.websocket.conmng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.messaging.SubProtocolWebSocketHandler;

public class CustomSubProtocolWebSocketHandler extends SubProtocolWebSocketHandler {
    private static final Logger logger = LoggerFactory.getLogger(CustomSubProtocolWebSocketHandler.class);

    public CustomSubProtocolWebSocketHandler(MessageChannel clientInboundChannel, SubscribableChannel clientOutboundChannel) {
        super(clientInboundChannel, clientOutboundChannel);
    }


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        logger.info("New websocket connection was established id:"+session.getId());
//        logger.info(session.getHandshakeHeaders().toString());
//        sessionHandler.register(session);
        super.afterConnectionEstablished(session);
    }
}
