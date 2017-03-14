package cn.hkfdt.xiaot.websocket.Beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 比赛用户交互对象
 * Created by whyse
 * on 2017/2/24 12:14
 */
public class GameUserStateBean  implements Serializable {
    /**
     * 1.下个页面是准备页
     2.继续比赛（已经参加的人）
     3.看动态排行（新人+已经确认退出）
     4.看静态排行
     */
    public int curState = 1;
    public String gameName;
    /**
     */
    public int userType;
    /**
     * 头像
     */
    public String headimgurl;
    public String userName;
    /**
     * 买卖点数据
     * 透传数据
     */
    public Object actions;
    public int userNum;//比赛人数
    public int curUserNum;//现在比赛人数

    public GameUserStateBean deepCopy() {
        GameUserStateBean item = new GameUserStateBean();
        item.headimgurl = this.headimgurl;
        item.curState = this.curState;
        item.gameName = this.gameName;
        item.userName = this.userName;
        item.userType = this.userType;
        item.actions = this.actions;
        if(this.actions==null){
            item.actions = new ArrayList<>(1);
        }
        return item;
    }

}
