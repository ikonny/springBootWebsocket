package cn.hkfdt.xiaot.web.common.globalinit;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 程序初始化后读取配置的一些常量放的地方
 * 初始值都会被覆盖
 * Created by whyse
 * on 2017/2/14 15:53
 */
public class GlobalInfo {
    static Logger logger = LoggerFactory.getLogger(GlobalInfo.class);
    private static String baseSSLUrl = "https://prodxiaot.investmaster.cn";
//    private static String domainHttp = "http://prodxiaot.investmaster.cn";
    public static String redisServer;
    public static int redisPort;
    public static String redisAuth;
    public static String imDomain;
    public static String wxLoginUrl;
    public static String wxAppsecret;
    public static String wxAppid;
    public static String wxToken;
    public static String serverDomain;
    public static String gameClientUrl="http://dev.forexmaster.cn/xiaoth/xiaot/game?type=battle";

    public static void printInfo() {
        Map<String,Object> mapTar = new LinkedHashMap<>(20);
        mapTar.put("qdBaseUrl",GlobalInfo.getBaseSSLUrl());

        logger.info("当前全局配置:"+ JSON.toJSONString(mapTar));
    }
    //=============================================================
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




}
