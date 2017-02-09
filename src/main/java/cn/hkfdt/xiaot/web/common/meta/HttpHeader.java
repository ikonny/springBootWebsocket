package cn.hkfdt.xiaot.web.common.meta;

/**
 * Created by zhaopingfei on 2015/11/5.
 * Powered by Rock
 * Fdt-Info:APP名称 (设备型号;分辨率;密度;语言;渠道)
 * Fdt-Did:(deviceid)  andorid是设备id，ios是idfa
 */
public class HttpHeader {

    /**
     * appname
     */
    private AppNameEnum appNameEnum;

    //get from User-Agent
    private String clientVersion;

    /**
     * @see  DeviceEnum
     */
    private DeviceEnum deviceEnum;

    private String screenSize;

    private String density;

    private String language;

    private String channel;

    private String deviceId;

    private String sysVersion;

    public String getSysVersion() {
        return sysVersion;
    }

    public void setSysVersion(String sysVersion) {
        this.sysVersion = sysVersion;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public AppNameEnum getAppNameEnum() {
        return appNameEnum;
    }

    public void setAppNameEnum(AppNameEnum appNameEnum) {
        this.appNameEnum = appNameEnum;
    }

    public DeviceEnum getDeviceEnum() {
        return deviceEnum;
    }

    public void setDeviceEnum(DeviceEnum deviceEnum) {
        this.deviceEnum = deviceEnum;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
