package cn.hkfdt.xiaot.websocket.protocol;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class ProtocolHelper {

	public static final String OK = "{\"rspCode\":200}";

	/**
	 * @param args
	 * author:xumin 
	 * 2017-1-10 下午4:46:37
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println(OK);
	}

	public static String getCommonJson(int rspCode, String msg) {
		Map<String, Object> map = new HashMap<String, Object>(2);
		map.put("rspCode", rspCode);
		map.put("msg", msg);
		return JSON.toJSONString(map);
	}

}
