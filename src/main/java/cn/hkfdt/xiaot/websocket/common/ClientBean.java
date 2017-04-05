package cn.hkfdt.xiaot.websocket.common;

import org.springframework.web.socket.WebSocketSession;

/**
 * Created by whyse
 * on 2017/4/5 14:17
 */
public class ClientBean {
    /**
     * 可以发送消息，也可以关闭连接
     */
    public WebSocketSession webSocketSession;
    public String fdtId;
}
