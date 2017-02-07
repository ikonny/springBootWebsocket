package cn.hkfdt.xiaot.websocket.conmng;

import cn.hkfdt.xiaot.websocket.utils.RSAUtil;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/*
 * 这个是连接信息接口
 */
@Component
public class WebSocketConnectionListener implements
		ApplicationListener<ApplicationEvent> {
	
	private static Logger logger = LoggerFactory.getLogger(WebSocketConnectionListener.class);
	private static final String FDT_KEY = "fdt-key"; 
    private static final String SIMP_SESSION_ID = "simpSessionId";
    public static Map<String, Object> mapTemp = new HashMap<String, Object>(1);
    public static ConcurrentHashMap<String, String> mapSession2FdtId = new ConcurrentHashMap<>(500);
    public static ConcurrentHashMap<String, String> mapFdtId2Session = new ConcurrentHashMap<>(500);
    
    final static String privateKeyFileInfo = "-----BEGIN PRIVATE KEY-----\n" +
            "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDDGwkSYK1ATXy4\n" +
            "Pc05ZhYli3aOxXfDzekpnGuCTREeOSoMsIgBet1t/FUxl1ABHP5QV6nYBAq2wrNb\n" +
            "8HUS0uqE0jdXFsCxCfRosroaKFaCujfhxOlsKFhq2OrqhHaocWzKJUjTMrnddJJI\n" +
            "5HR81NJ64fK0j5+EY1EOOs1JZsVuALjG7eTpIQW7bNApnm7GHB7huJT4qzrfrGKF\n" +
            "s0nhhdcxGGskJ6RNcqjXdo/eUoAERWY9UXU+VIQwp0/Luus2m7Wk8dCniuBEAoXL\n" +
            "lXcXAHwnl7xZz6C0UviOuvF2JshGOPbTYy9G0/EQ7h1JALhXuB8U81KXfF1fCwNL\n" +
            "peUzVTRhAgMBAAECggEBAJnCt76NBF0V9EG7Kv6ebru+EnxoMX/VyniptqylEeWQ\n" +
            "xYvkn/sSmmmwoG+JwVpvQBmPTOJaJRttjC7b7VgdcwekKErxOoELyFuu5y3wNmWm\n" +
            "Xp4GMrOzhCMIuvKB3IXZhhQ1mBQh+QsHcLYTnZ43l32SjlUwj1Wlc97UBq9fWB7c\n" +
            " /2ayFc/ET7xxv+xBOOidFiCJNe/+Lxh5h3yRxOmpyCsMKy+TtPww3gVmtNKdkx49\n" +
            "G4vp6miFtbwu0/ADgMOu1pacNCbSvqcjAcK2jpIktGmgfmN7gMTDPfUu2BEej8bF\n" +
            " /tX+9LPUj05BhB7siTcHlSPZ6nZOFsxsAEcSGXk0KbECgYEA8dMnHSL6VFVAe/0O\n" +
            "XoyN2FZ7JXXxeGTpOtnqPr5+QeGqM8oKRBOo14aeMmzuSwR4qa/YHhG5/wSxEF8m\n" +
            "9vnG8LqZqgFCw4gQoMyTKbDjVUl/6r5a65GrI3DVWSySCUrQfidIMcQlSvmX3g9O\n" +
            "2SY7H0HCFliMetswg7AtPLst/GUCgYEAzorPP6I3NenKn7EZiDLTJyBV9o9wQ4ZL\n" +
            "B1L/Z4T/PL4pq9Ei8v6BBR197ApyfPWHWJvmcTBcLPc9zfwXmcZm1PoxACCR3jkT\n" +
            "A7ukpvXAusOPqahfhuyekfLdfqHxaK/pSyqY4fznce30p+pDWvcOhHCYwECKTNcP\n" +
            "URhHqPkxgk0CgYEAwUIldSSZ+EG1aiFflXIwfd8HRXXPh47l0ZGLoZ8tWctV8VOb\n" +
            "BrLLcYr07ImfmrY1FC8iwU0bXtHKC7Jvels9gO8vlOyzBX69AzTauyvRUjyODPUZ\n" +
            "xj9BDO7EoiJ7hw+SNe+Aw7zkrNlxZBbJxcLG5wDvclpL0ndPez6VuH5Cjv0CgYA0\n" +
            "KG2p3icfIEkhBrIx6NPV356VwydQhgtQcC87TyS9jDAtyYSP5KFkT0xLXWAIGmDx\n" +
            "iX0qPFIqsM0UxYKYPLgfNIdHRvJPMg6RNMOhvhHLmDMhXvmwsvRgWvqAThkOnM3H\n" +
            "Q5yUBS/VX4gXF1unDxjFbUHF2waR3QVrLzx5eWR9SQKBgGKyAxeuHnDTKMzFcT28\n" +
            "HxCrS2EkYDJR7/tCMcvTlnJeJHjQg7EZc/0iZQ3dFdSD/LrppB1a79WnP32MCplP\n" +
            "IY3tmqCVGTumj/4GkzAJeA8AP/wBF8QXkyxU3IDl4SwkGY25Ms4BS9HiOJmvvRtO\n" +
            "e88F2PuMFZamJ1zeaeDCoRPc\n" +
            "-----END PRIVATE KEY-----";
    public static String tokenTest ="O7+f4S3OUrioKD/JnRZz86W2Pi+9l4L4E36oQzJbkpvwSG7w+rocKAhsXi6P0J" +
            "ykE5O9cUW5oS5dTDGBQOvURAywWx3XJuHZO70o6zNhc14H+15P66ikibJiPnGDXNoWw" +
            "YH8YAnURm8fvMtwRtYx3qBM6o4XoQfZXefw1wzum/0Vm/t2nskLkUDlvXAxwRjl+rO1g6JfI" +
            "v1+H3ez9Db56QUg75mp1U/bfV+yceBy+WLHtYsLyWXyQqZDV3uG6tPZquhenw8jtGPprpU1XESf" +
            "Qkzago2izYKtFNEFdfe+N2p+kJ3+SzcGbhYDaVuNYg28YEs2ZYAOXlNdSU4J4Hto3w==";
    private static RSAPrivateKey key;
    static{
    	try {
            key = RSAUtil.initKey(privateKeyFileInfo.getBytes("utf-8"));
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    //===================================================
	

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof SessionConnectEvent) {
			handleSessionConnected((SessionConnectEvent) event);
		} else if (event instanceof SessionDisconnectEvent) {
			handleSessionDisconnect((SessionDisconnectEvent) event);
		}
//		System.err.println(event.toString());
	}
	// SessionDisconnectEvent[sessionId=8v_ueimg, CloseStatus[code=1000, reason=null]]
	private void handleSessionDisconnect(SessionDisconnectEvent event) {
		SimpMessageHeaderAccessor headers = SimpMessageHeaderAccessor.wrap(event.getMessage());
		String sessionId = (String) headers.getHeader(SIMP_SESSION_ID);
		removeUserId(sessionId);
//		System.err.println("handleSessionDisconnect");
	}
	//[stompCommand=CONNECT, null, null, null, nativeHeaders={fdt-id=[123], accept-version=[1.1,1.0], 
	//heart-beat=[10000,10000]}, simpMessageType=CONNECT,
	//null, null, null, null, null, null, simpHeartbeat=[J@5c7d82d, simpSessionId=nhdw6oj_, null, null]
	private void handleSessionConnected(SessionConnectEvent event) {
		SimpMessageHeaderAccessor headers = SimpMessageHeaderAccessor.wrap(event.getMessage());
		String sessionId = (String) headers.getHeader(SIMP_SESSION_ID);
		String fdtId = sessionId;
		List<String> fdtKeyList = headers.getNativeHeader(FDT_KEY);
		if(fdtKeyList!=null){
			String fdtKey = fdtKeyList.get(0);
			fdtId = getFdtId(fdtKey,sessionId);
		}else{
			logger.info("sessionId: "+sessionId+"__获取不到fdtKey");
		}
		setUserIds(fdtId,sessionId);
//		System.err.println("handleSessionConnected");
	}
	
	private void setUserIds(String fdtId, String sessionId) {
		mapSession2FdtId.put(sessionId, fdtId);
		mapFdtId2Session.put(fdtId, sessionId);
		logger.info("设置连接:fdtId "+fdtId);
	}
	private void removeUserId(String sessionId) {
		String fdtId = mapSession2FdtId.get(sessionId);
		if(!StringUtils.isEmpty(fdtId)){
			mapSession2FdtId.remove(sessionId);
			mapFdtId2Session.remove(fdtId);
			logger.info("-------断开:fdtId "+fdtId);
		}
	}
	private static String getFdtId(String fdtKey, String sessionId) {
		try {
			//{"exp":1476859144613,"phone":"8613675841954","market":"SC","email":"jie.ding@hkfdt.cn",
			//"Id":"mb000000003","language":"CN","utype":90,"country":"CN"}
			String verifyJson = RSAUtil.decodeTokenByKey(key, fdtKey);
			Map<String, Object> map = (Map<String, Object>) JSON.parseObject(verifyJson, mapTemp.getClass());
			String fdtId = map.get("Id").toString();
			return fdtId;
		} catch (Exception e) {
			logger.info("token出错");
		}
		return sessionId;
	}
	//=============================================
	public static void main(String[] args){
		System.out.println(getFdtId("sd","sdfssssssssssssss"));
		
	}
}
