package cn.hkfdt.xiaot.web.common;

/**
 * Created by zhaopingfei on 2015/11/2.
 * Powered by Rock
 */
public final class DeviceContext {
    private static ThreadLocal<DeviceInfo> deviceInfo = new ThreadLocal<>();

    private DeviceContext() {
    }

    public static ThreadLocal<DeviceInfo> getDeviceInfo() {
        return deviceInfo;
    }


    public static DeviceInfo getDevice() {
        return deviceInfo.get();
    }
}
