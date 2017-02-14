package cn.hkfdt.xiaot.web.common.globalinit;

/**
 * 程序初始化后读取配置的一些常量放的地方
 * 初始值都会被覆盖
 * Created by whyse
 * on 2017/2/14 15:53
 */
public class GlobalInfo {

    private static String baseSSLUrl="https://prod.forexmaster.cn";
    private static String domainHttp = "http://prod.forexmaster.cn";
    /**
     * 读取system_settings key_code = 'SSLURI' 的值
     * https://test.forexmaster.cn
     */
    public static String getBaseSSLUrl() {
        return baseSSLUrl;
    }

    public static void setBaseSSLUrl(String baseSSLUrl) {
        GlobalInfo.baseSSLUrl = baseSSLUrl;
    }

    public static String getDomainHttp() {
        return domainHttp;
    }

    public static void setDomainHttp(String domainHttp) {
        GlobalInfo.domainHttp = domainHttp;
    }
}
