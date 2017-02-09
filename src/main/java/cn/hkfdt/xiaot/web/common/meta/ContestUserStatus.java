package cn.hkfdt.xiaot.web.common.meta;

/**
 * Created by crimson on 16/11/21.
 * 比赛用户状态枚举
 */
public enum ContestUserStatus {
    INCONTEST(1,"比赛中"),
    DISQUALIFY(2,"失去资格"),
    QUIT(3,"主动退出");


     ContestUserStatus(int value,String name){

        this.value = value;
        this.name = name;
    }

    private int value;
    private String name;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
