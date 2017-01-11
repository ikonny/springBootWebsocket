package cn.hkfdt.xiaot.websocket.interceptors;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

public class XiaoTShareInterceptor extends HttpSessionHandshakeInterceptor {

	private static Logger logger = LoggerFactory.getLogger(HttpSessionHandshakeInterceptor.class);

	/**
	 * @param args
	 *            author:xumin 2017-1-9 下午7:20:56
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterHandshake(ServerHttpRequest request,
			ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception ex) {
		// TODO Auto-generated method stub
		super.afterHandshake(request, response, wsHandler, ex);
	}

	@Override
	public boolean beforeHandshake(ServerHttpRequest arg0,
			ServerHttpResponse arg1, WebSocketHandler arg2,
			Map<String, Object> arg3) throws Exception {

//		System.out.println("beforeHandshake：建立连接的时候只调用一次");
//		if (arg0 instanceof ServletServerHttpRequest) {
//			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) arg0;
//			System.err.println(servletRequest.toString());
//			HttpSession session = servletRequest.getServletRequest().getSession(false);
//			if (session != null) {
//				// 使用userName区分WebSocketHandler，以便定向发送消息
//				String httpSessionId = session.getId();
//				System.err.println(httpSessionId);
//			} else {
//			}
//		}
		return true;
	}

}
