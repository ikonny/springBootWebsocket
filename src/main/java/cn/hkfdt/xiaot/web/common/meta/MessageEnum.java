package cn.hkfdt.xiaot.web.common.meta;

/**
 * Created by zhaopingfei on 2015/10/25.
 * Powered by Rock
 */
public enum MessageEnum {
    UNKNOW("UNKNOW", "0", "0");

    MessageEnum(String meaning, String value, String flag) {
        this.meaning = meaning;
        this.value = value;
        this.flag = flag;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getValue() {
        return value;
    }

    public String getFlag() {
        return flag;
    }

    private final String meaning;

    private final String value;

    private final String flag;

    public static MessageEnum getEnumbyFlag(String flag) {
        for (MessageEnum m : MessageEnum.values()) {
            if (m.getFlag().equals(flag)) {
                return m;
            }
        }
        return null;
    }
}
