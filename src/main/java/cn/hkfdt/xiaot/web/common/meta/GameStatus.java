package cn.hkfdt.xiaot.web.common.meta;

/**
 * Created by crimson on 17/2/27.
 */
public enum GameStatus {
    ABOUT(0, "未开始"),
    UNDERWAY(1, "进行中"),
    OVER(2, "已结束"),
    FULL(3, "满员");

    private int status;
    private String desc;

    GameStatus(int status, String desc){
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
