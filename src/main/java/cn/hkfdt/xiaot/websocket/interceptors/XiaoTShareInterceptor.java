package cn.hkfdt.xiaot.websocket.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

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

//		HttpHeaders httpHeaders = arg0.getHeaders();
//		logger.info(httpHeaders.toString());
		String clientIp = getIp(arg0);
		logger.info("clientAddress_:_"+clientIp);

//		if(!httpHeaders.get("xumin").get(0).toString().equals("admin")){
//			return false;
//		}
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
	/*
	{upgrade=[websocket], connection=[upgrade], host=[devxiaot.forexmaster.cn],
	x-real-ip=[202.96.126.186], x-forwarded-for=[202.96.126.186], x-forwarded-proto=[http],
	origin=[http://devxiaot.forexmaster.cn], sec-websocket-protocol=[v10.stomp, v11.stomp],
	pragma=[no-cache], cache-control=[no-cache],
	sec-websocket-key=[XajWUa90k+NDz2L1uoUTGw==],
	sec-websocket-version=[13], sec-websocket-extensions=[x-webkit-deflate-frame],
	user-agent=[Mozilla/5.0 (iPhone; CPU iPhone OS 10_2_1 like Mac OS X)
	AppleWebKit/602.4.6 (KHTML, like Gecko) Mobile/14D27 fdt_scheme/ForexMasterCN
	fdt/iOS_CN fdt_version/5.0.0]}
	 */
	private String getIp(ServerHttpRequest arg0) {
		HttpHeaders httpHeaders = arg0.getHeaders();
		String ip = null;
		if(httpHeaders.containsKey("x-forwarded-for")){
			return ip = httpHeaders.get("x-forwarded-for").get(0);
		}
		if(httpHeaders.containsKey("Proxy-Client-IP")){
			return ip = httpHeaders.get("Proxy-Client-IP").get(0);
		}
		if(httpHeaders.containsKey("WL-Proxy-Client-IP")){
			return ip = httpHeaders.get("WL-Proxy-Client-IP").get(0);
		}
		return arg0.getRemoteAddress().toString();
	}

}
