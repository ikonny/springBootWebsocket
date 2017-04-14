package cn.hkfdt.xiaot.websocket.beans;

import cn.hkfdt.xiaot.common.beans.GameUserBean;

import java.io.Serializable;

/**
 * 排行榜对象
 * Created by whyse
 * on 2017/2/24 12:14
 */
public class GameUserListBean extends GameUserBean implements Serializable {
    /**
     * 收益率
     */
    public double returnRate;
    /**
     * 比赛次数
     */
    public int count;

    public GameUserListBean deepCopy() {
        GameUserListBean item = new GameUserListBean();
        item.returnRate = this.returnRate;
        item.userType = this.userType;

        item.userName = this.userName;
        item.headimgurl = this.headimgurl;
        item.userId = this.userId;
        item.count = this.count;
        return item;
    }
}
