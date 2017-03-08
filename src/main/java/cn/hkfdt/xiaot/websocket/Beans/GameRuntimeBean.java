package cn.hkfdt.xiaot.websocket.Beans;

import cn.hkfdt.xiaot.mybatis.model.ltschina.TGame;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TQuestions;
import cn.hkfdt.xiaot.websocket.topic.XiaoTMatchTopics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static cn.hkfdt.xiaot.websocket.service.impl.MatchServiceHelper.cacheMapXM;

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
    public volatile  int userNum;
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
    /**
     * 服务端计时比赛状态字段
     * 0创建未开始 1：开始未结束  2：已经结束
     */
    private volatile int state=0;
    //================================================================================

    /**
     * 用户准备，或者重连准备
     * @param gameUserExtBean
     */
    public void insertGameUser(GameUserExtBean gameUserExtBean) {
        GameUserExtBean temp = mapUsers.get(gameUserExtBean.userId);
        if(temp==null) {
            //新人
            temp = gameUserExtBean;
        }else{
            //老人重新准备
        }
        temp.state = 0;
        mapUsers.put(temp.userId, temp);
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
     * 判断游戏是否可以开始
     * @return
     */
    public boolean isGameCanGo() {
        return mapUsers.size()>0;
    }
    /**
     * 用户主动结束比赛操作
     * 不能再次进入
     * @param userId
     * @return 1所有用户都告诉比赛结束  0成功
     */
    public int gameUserEnd(String userId) {
        GameUserExtBean gameUserExtBean = mapUsers.get(userId);
        if(gameUserExtBean!=null){
            synchronized (mapUsersEnd) {
                mapUsersEnd.put(userId, gameUserExtBean);
                gameUserExtBean.state = 1;
                if(mapUsersEnd.size()==userNum){
                    return 1;
                }
            }
        }
        return 0;
    }

    /**
     * 用户断线，可以再次进入，注意超时回收类似主动结束
     * @param fdtId
     * @param sessionId
     */
    public void disConnectAndAfterRmove(String fdtId, String sessionId) {
        GameUserExtBean gameUserExtBean = mapUsers.get(fdtId);
        if(gameUserExtBean!=null){
            synchronized (mapUsersEnd) {
                gameUserExtBean.state = 2;
                mapUsersEnd.put(fdtId, gameUserExtBean);
                logger.info("比赛运行时断线fdtId："+fdtId);
            }
        }
    }

    //=============================================================

    /**
     * 根据比赛类型，每秒发送比赛x点位置，直到发完，回收线程
     * @param xiaoTMatchTopics
     */
    public synchronized void start(XiaoTMatchTopics xiaoTMatchTopics) {
        int xPoints = 200;//XiaoTMarketType.FC.getType()
//        if(tGame.getMarketType()== XiaoTMarketType.FC.getType()){
//
//        }
        if(state>0){
            return;
        }
        state = 1;
        Thread td = new Thread(()->{
            int xNow = 1;
            while(xNow<=xPoints){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //1.发送本次x坐标
                xiaoTMatchTopics.sendGameTimeLine(gameId,xNow);
                //2.
                ++xNow;
            }
            //-------------------
            cacheMapXM.put(gameId,this,3);//比赛结束后，3秒后结束
            state = 2;
        });
        td.setName("game_:"+gameId);
        td.start();
    }
}
