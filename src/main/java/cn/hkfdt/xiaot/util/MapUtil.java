package cn.hkfdt.xiaot.util;

import java.util.Map;
import java.util.HashMap;

public class MapUtil {

	/**
	 * 通用前后端报错map
	 * @param errorCode
	 * @param errorMsg
	 * @return
	 */
	public static Map<String,Object> getErrorMap(int errorCode, String errorMsg) {
		Map<String,Object> map = new HashMap<>(5);
		map.put("errorCode",errorCode);
		map.put("errorMsg",errorMsg);
		return map;
	}
}
