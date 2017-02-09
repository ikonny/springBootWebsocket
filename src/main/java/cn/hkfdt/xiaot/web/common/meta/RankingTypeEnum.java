package cn.hkfdt.xiaot.web.common.meta;

/**
 * Created by crimson on 16/11/1.
 */
public enum RankingTypeEnum {
    SCORE_TYPE("score",1),
    ROI_TYPE("roi",2);

    RankingTypeEnum(String name, int value) {
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
