package cn.hkfdt.xiaot.websocket.Beans;

import cn.hkfdt.xiaot.mybatis.model.ltschina.TGame;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TQuestions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 比赛运行时数据
 * Created by whyse
 * on 2017/2/27 11:41
 */
public class GameRuntimeBean {
    static Logger logger = LoggerFactory.getLogger(GameRuntimeBean.class);
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
     * 比赛结束后，mapUsers的元素将会移动到这个结构,或者断线的用户也会放到这个地方
     * 重连后再恢复移除这边引用
     */
    public Map<String,GameUserExtBean> mapUsersEnd;
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
    //================================================================================

    public void insertGameUser(GameUserExtBean gameUserExtBean) {
        mapUsers.put(gameUserExtBean.userId,gameUserExtBean);
//        listUser.add(gameUserExtBean);
    }

    /**
     * true 当前用户已经在比赛，当前人数未满可以加比赛
     * false 当前人数已经满了,新用户不能进
     * @param userId
     * @return
     */
    public boolean canJoinGame(String userId) {
        if(userId!=null && mapUsers.containsKey(userId))
            return true;
        return mapUsers.size()<userNum;
    }

    /**
     * 判断是否游戏人数已经满了
     * @return
     */
    public boolean isUserAllReady() {
        return mapUsers.size()==userNum;
    }
    /**
     * 用户主动结束比赛操作
     * @param userId
     * @return 1所有用户都告诉比赛结束  0成功
     */
    public int gameUserEnd(String userId) {
        GameUserExtBean gameUserExtBean = mapUsers.get(userId);
        if(gameUserExtBean!=null){
            synchronized (mapUsersEnd) {
                mapUsersEnd.put(userId, gameUserExtBean);
                if(mapUsersEnd.size()==userNum){
                    return 1;
                }
            }
        }
        return 0;
    }

    public void disConnectAndAfterRmove(String fdtId, String sessionId) {
        GameUserExtBean gameUserExtBean = mapUsers.get(fdtId);
        if(gameUserExtBean!=null){
            synchronized (mapUsersEnd) {
                mapUsersEnd.put(fdtId, gameUserExtBean);
                logger.info("比赛运行时断线fdtId："+fdtId);
            }
        }
    }


}
