package cn.hkfdt.xiaot.web.common.meta;

/**
 * Created by zhaopingfei on 2015/11/5.
 * Powered by Rock
 */
public enum DeviceEnum {
    IPHONE("iphone"), ANDROID("android"), IPAD("IPAD");

    DeviceEnum(String name) {
        this.name = name;
    }

    String name;

    public String getName() {
        return name;
    }


    public  static boolean  isIos(DeviceEnum device){
        return device == IPHONE || device == IPAD;
    }


    public static DeviceEnum getEnumByDevice(String deviceName){
        for(DeviceEnum de:DeviceEnum.values()){
            if(de.getName().equalsIgnoreCase(deviceName)){
                return de;
            }
        }
        return null;
    }

}
