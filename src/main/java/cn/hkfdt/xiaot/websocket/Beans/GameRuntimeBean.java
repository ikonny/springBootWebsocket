package cn.hkfdt.xiaot.websocket.Beans;

import cn.hkfdt.xiaot.mybatis.model.ltschina.TGame;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TQuestions;

import java.util.Map;

/**
 * 比赛运行时数据
 * Created by whyse
 * on 2017/2/27 11:41
 */
public class GameRuntimeBean {
    /**
     * 比赛人数
     */
    public int userNum;
    public String gameId;
    /**
     * 排过序的list,里面引用的对象一样
     */
//    public List<GameUserExtBean> listUser;
    /**
     * 用户map表，将会在创建比赛的时候初始化大小
     */
    public Map<String,GameUserExtBean> mapUsers;
    /**
     * 比赛结束后，mapUsers的元素将会移动到这个结构
     */
    public Map<String,GameUserExtBean> mapUsersEnd;
    //======================================
    /**
     * 当服务端发现serverVersion == clientVersion证明客户端没有更新，不需要排序（有可能已经比赛结束）
     * 服务端每排序一次，serverVersion = clientVersion
     */
    public int serverVersion = 0;
    /**
     * 客户端每次更新本次信息，改字段+1
     */
    public int clientVersion = 0;
    /**
     * 一个没有jsonData的题目结构
     */
    public TQuestions tQuestions;
    /**
     * 比赛数据，含有比赛id，人数，比赛名称等
     */
    public TGame tGame;

    public void insertGameUser(GameUserExtBean gameUserExtBean) {
        mapUsers.put(gameUserExtBean.userId,gameUserExtBean);
//        listUser.add(gameUserExtBean);
    }
    public boolean canJoinGame() {
        return mapUsers.size()<userNum;
    }
}
