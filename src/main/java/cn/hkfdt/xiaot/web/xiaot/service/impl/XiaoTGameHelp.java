package cn.hkfdt.xiaot.web.xiaot.service.impl;

import cn.hkfdt.xiaot.util.MapUtil;
import cn.hkfdt.xiaot.util.QrCodeUtil;
import cn.hkfdt.xiaot.web.common.globalinit.GlobalInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class XiaoTGameHelp {

	static Logger logger = LoggerFactory.getLogger(XiaoTGameHelp.class);

	/**
	 * 如果顺利则生成结果，不顺利也生成相关...
	 * @param mapPara {"userNum":10,"gameName":"aa对抗赛","marketType":0}
	 * @param gameId
	 * @return
	 */
	public static Map<String,Object> genQRinfo(Map<String, Object> mapPara, String gameId) {
		Map<String, Object> resultMap =null;
		try {
			resultMap = new HashMap<>(3);
			int num = Integer.parseInt(mapPara.get("userNum").toString());
			String url = GlobalInfo.gameClientUrl + "?gameId=" + gameId + "&num=" + num;
			resultMap.put("img", QrCodeUtil.createImage2Base64(url));
			resultMap.put("gameId", gameId);
			resultMap.put("url", url);
		}catch (Exception e){
			resultMap = MapUtil.getErrorMap(201,"生成二维码出错");
		}
		return resultMap;
	}
}
