package cn.hkfdt.xiaot.web.weixin;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by whyse
 * on 2017/2/21 15:42
 */
public class WXHelper {
    public static final String wxToken = "xuminadmin";

    /**
     * 判断是否来自微信浏览器打开
     * @param request
     * @return
     */
    public static boolean isFromWx(HttpServletRequest request) {
        String ua = request.getHeader("User-Agent");
        return ua.contains("MicroMessenger");
    }
}
