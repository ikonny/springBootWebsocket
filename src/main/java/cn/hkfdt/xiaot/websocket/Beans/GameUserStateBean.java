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
     * 1新人，比赛未开始可以准备    准备后  成功，比赛已经开始或者结束，提示错误    {"data":{gameState:1,gameName},"rspCode":200}
     2.已参赛人，比赛未开始 {"data":{gameState:2,userName,userType,headimgurl,gameName},"rspCode":200}   再去ready请求一次
     3.已参赛人，比赛进行中   {"data":{gameState:3,actions,userName,userType,headimgurl,gameName},"rspCode":200}      建立连接，实时发送变化数据，订阅比赛结束等信息
     4.已参赛人，比赛已经结束   {"data":{gameState:4,},"rspCode":200}
     */
    public int gameState = 1;
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

    public GameUserStateBean deepCopy() {
        GameUserStateBean item = new GameUserStateBean();
        item.headimgurl = this.headimgurl;
        item.gameState = this.gameState;
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
