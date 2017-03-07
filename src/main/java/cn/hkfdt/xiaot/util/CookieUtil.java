package cn.hkfdt.xiaot.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by crimson on 17/3/7.
 */
public class CookieUtil {


    /**
     * 设置cookie
     * @param response
     * @param age  生命周期,秒
     * @param domain   域名
     * @param path  路径
     * @param key   cookie名
     * @param value cookie内容
     */
    public static void setCookie(HttpServletResponse response, int age,
                   String domain, String path, String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setDomain(domain);
        cookie.setMaxAge(age);
        cookie.setPath(path);
        response.addCookie(cookie);
    }


    public static String getCookie(String key, HttpServletRequest request){
        if(key == null || "".equals(key)){
            return null;
        }
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(key.equals(cookie.getName())){
                return cookie.getValue();
            }
        }
        return null;
    }
}
