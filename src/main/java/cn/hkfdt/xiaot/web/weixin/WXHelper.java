package cn.hkfdt.xiaot.web.weixin;

import cn.hkfdt.xiaot.web.common.globalinit.GlobalInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by whyse
 * on 2017/2/21 15:42
 */
public class WXHelper {
    /**
     * 判断是否来自微信浏览器打开
     * @param request
     * @return
     */
    public static boolean isFromWx(HttpServletRequest request) {
        String ua = request.getHeader("User-Agent");
        return ua.contains("MicroMessenger");
    }

    public static String getReqAccTokenUrl(String code) {
        return "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" +
                GlobalInfo.wxAppid + "&secret=" + GlobalInfo.wxAppsecret + "&code=" +
                code + "&grant_type=authorization_code";
    }

    public static String getAccTokenRefUrl(Map<String, Object> mapTemp) {
        String rToken = mapTemp.get("refresh_token").toString();
        return "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=" +
                GlobalInfo.wxAppid + "&grant_type=refresh_token&refresh_token=" + rToken;
    }

    public static String getUserInfoUrl(Map<String, Object> mapTemp) {
        String openId = mapTemp.get("openid").toString();
        String aToken = mapTemp.get("access_token").toString();
        return "https://api.weixin.qq.com/sns/userinfo?access_token=" +
                aToken + "&openid=" + openId + "&lang=zh_CN";
    }
}
