package cn.hkfdt.xiaot.web.common;


import cn.hkfdt.xiaot.web.common.meta.AppNameEnum;

/**
 * Created by zhaopingfei on 2015/11/2.
 * Powered by Rock
 */
public class DeviceInfo {

    //app名称
    private AppNameEnum appName;

    /**
     * IOS/ANDROID
     */
    private String deviceName;

    //语言
    private String lang;

    //地区
    private String country;

    //客户端版本
    private String clientVersion;

    //record user ip
    private String ip;

    /**
     * 渠道
     */
    private String channel;

    /**
     * 设备id
     */
    private String did;

    /**
     * client 的系统版本
     */
    private String sysVersion;

    public String getSysVersion() {
        return sysVersion;
    }

    public void setSysVersion(String sysVersion) {
        this.sysVersion = sysVersion;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public AppNameEnum getAppName() {
        return appName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setAppName(AppNameEnum appName) {
        this.appName = appName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    @Override
    public String toString() {
        return "DeviceInfo{" +
                "appName=" + appName +
                ", lang='" + lang + '\'' +
                ", country='" + country + '\'' +
                ", clientVersion='" + clientVersion + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
