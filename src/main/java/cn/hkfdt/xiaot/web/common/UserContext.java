package cn.hkfdt.xiaot.web.common;

/**
 * Created by hzzhaopingfei on 2015/10/7.
 * Powered by Rock
 */
public final class UserContext {

    private static final ThreadLocal<ThreadLocalUserInfo> userInfo = new ThreadLocal<>();

    private UserContext() {
    }

    public static ThreadLocal<ThreadLocalUserInfo> getUserInfo() {
        return userInfo;
    }
}