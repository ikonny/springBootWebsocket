package cn.hkfdt.xiaot.websocket.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 代理管理所有用户的连接关闭和自定义收发信息
 * Created by whyse
 * on 2017/4/5 14:07
 */
public class ClientAgentMng {
    private static final Logger logger = LoggerFactory.getLogger(ClientAgentMng.class);
    /**
     * 连接建立后，设置sessionId对应WebSocketSession的关系
     */
    public static ConcurrentHashMap<String, ClientBean> mapSession2ClientSession = new ConcurrentHashMap<>(100);
    public static SimpMessagingTemplate simpMessagingTemplate;

    //==========================================================================
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
        ClientBean clientBean = mapSession2ClientSession.get(sessionIdOlder);
        if(clientBean!=null){
            try {
                clientBean.webSocketSession.close();
                logger.info("主动关闭连线OK："+sessionIdOlder);
                handleSessionDisconnect(sessionIdOlder);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 1;
        }
        return -1;
    }

    public static void afterConnectionEstablished(WebSocketSession session) {
        String sessionId = session.getId();
        ClientBean clientBean = new ClientBean();
        clientBean.webSocketSession = session;
        mapSession2ClientSession.put(sessionId,clientBean);
    }

    //=================================================================

    /**
     * 发送信息给客户端
     * @param sessionId
     * @param destination "/queue/test/send"
     * @param msg
     */
    public static void send(String sessionId, String destination, String msg) {
        destination = destination+"-user"+sessionId;
        simpMessagingTemplate.convertAndSend(destination,msg);
    }
}
