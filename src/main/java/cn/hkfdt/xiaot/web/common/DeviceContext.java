package cn.hkfdt.xiaot.web.common;

/**
 * Created by zhaopingfei on 2015/11/2.
 * Powered by Rock
 */
public final class DeviceContext {
    private static final ThreadLocal<DeviceInfo> deviceInfo = new ThreadLocal<>();

    private DeviceContext() {
    }

    public static ThreadLocal<DeviceInfo> getDeviceInfo() {
        return deviceInfo;
    }
}
