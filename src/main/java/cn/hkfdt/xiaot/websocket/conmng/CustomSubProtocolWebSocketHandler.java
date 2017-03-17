package cn.hkfdt.xiaot.websocket.conmng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.messaging.SubProtocolWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class CustomSubProtocolWebSocketHandler extends SubProtocolWebSocketHandler {
    private static final Logger logger = LoggerFactory.getLogger(CustomSubProtocolWebSocketHandler.class);
    /**
     * 连接建立后，设置sessionId对应WebSocketSession的关系
     */
    public static ConcurrentHashMap<String, WebSocketSession> mapSession2ClientSession = new ConcurrentHashMap<>(500);

    public CustomSubProtocolWebSocketHandler(MessageChannel clientInboundChannel, SubscribableChannel clientOutboundChannel) {
        super(clientInboundChannel, clientOutboundChannel);
    }


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String sessionId = session.getId();
//        logger.info("New websocket connection was established id:"+session.getId());
//        logger.info(session.getHandshakeHeaders().toString());

//        mapSession2ClientSession.put(sessionId,session);
        super.afterConnectionEstablished(session);
    }

    /**
     * 断线后回调这个方法，去除之前的索引
     * @param sessionId
     */
    public static void handleSessionDisconnect(String sessionId) {
        mapSession2ClientSession.remove(sessionId);
    }

    /**
     * 主动断开连接，如果成功返回1
     * @param sessionIdOlder
     * @return
     */
    public static int disconnect(String sessionIdOlder) {
        WebSocketSession session = mapSession2ClientSession.get(sessionIdOlder);
        if(session!=null){
            try {
                session.close();
                logger.info("主动关闭连线OK："+sessionIdOlder);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 1;
        }
        return -1;
    }
}
