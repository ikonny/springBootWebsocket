package cn.hkfdt.xiaot.web.common.meta;

/**
 * Created by crimson on 16/11/1.
 */
public enum ROITypeEnum {
    ONE_DAY("day",1),
    FIVE_DAY("week",2),
    ONE_MONTH("month",3),
    ALL_OVER("total",4);

    ROITypeEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    private String name;
    private int value;

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}