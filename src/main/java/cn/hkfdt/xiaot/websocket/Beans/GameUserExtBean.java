package cn.hkfdt.xiaot.websocket.Beans;

import cn.hkfdt.xiaot.common.beans.GameUserBean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 比赛用户交互对象
 * Created by whyse
 * on 2017/2/24 12:14
 */
public class GameUserExtBean extends GameUserBean implements Serializable {
    public String gameId;
    /**
     * 收益率
     */
    public double returnRate;
    /**
     * 横坐标
     */
    public int curIdx;
    /**
     * 买卖点数据
     * 透传数据
     */
    public Object actions;
    /**
     * 0: 正常  1：已经确认退出（不得重连）  2:断线  3:比赛正常退出
     */
    public volatile int state=0;

    public GameUserExtBean deepCopy() {
        GameUserExtBean item = new GameUserExtBean();
        item.curIdx = this.curIdx;
        item.userId = this.userId;
        item.gameId = this.gameId;
        item.returnRate = this.returnRate;
        item.headimgurl = this.headimgurl;
        item.userName = this.userName;
        item.userType = this.userType;
        item.actions = this.actions;
        item.state = this.state;
        if(this.actions==null){
            item.actions = new ArrayList<>(1);
        }
        return item;
    }
}
