package cn.hkfdt.xiaot.websocket.Beans;

import cn.hkfdt.xiaot.mybatis.model.ltschina.TGame;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TQuestionsNew;
import cn.hkfdt.xiaot.web.xiaot.util.XiaoTMarketType;
import cn.hkfdt.xiaot.websocket.service.impl.MatchServiceHelper;
import cn.hkfdt.xiaot.websocket.topic.XiaoTMatchTopics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static cn.hkfdt.xiaot.websocket.service.impl.MatchServiceHelper.cacheMapXM;

/**
 * 比赛运行时数据
 * Created by whyse
 * on 2017/2/27 11:41
 */
public class GameRuntimeBean {
    static Logger logger = LoggerFactory.getLogger(GameRuntimeBean.class);
    /**
     * 准备列表只展示前面30个人
     */
    public static final int readyInfoSizeShow = 30;
    /**
     * 动态排行榜，客户端订阅的有限制50人
     */
    public static final int listInfoSizeShow = 50;
    /**
     * 比赛人数
     */
    public volatile  int userNum;
    public String gameId;
    /**
     * 当前排名，在排名后会被记录
     */
    public List<GameUserListBean> listRank;
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
     * 客户端每次更新本次信息，改字段+1,使下次变化发送到裁判端
     */
    public int clientVersion = 0;
    /**
     * 一个没有jsonData的题目结构
     */
    public TQuestionsNew tQuestions;
    /**
     * 比赛数据，含有比赛id，人数，比赛名称等
     */
    public TGame tGame;
    /**
     * 服务端计时比赛状态字段
     * 0创建未开始 1：开始未结束  2：已经结束
     */
    public volatile int state=0;
    boolean startFirst = false;
    /**
     * 是否操作完数据库，操作完了就是1，证明比赛结束并且不需要记录里面的数据了
     */
    AtomicInteger dbUpdateState= new AtomicInteger(0);
    //================================================================================
    /**
     * 根据比赛类型，获取比赛时长
     * @return
     */
    public int getGameTime() {
        if(tGame.getMarketType()== XiaoTMarketType.FC.getType()){
            return 200+50;
        }
        if(tGame.getMarketType()== XiaoTMarketType.SC.getType()){
            return 240+50;
        }
        if(tGame.getMarketType()== XiaoTMarketType.FX.getType()){
            return 300+50;
        }
        return 300;
    }
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
            //老人重新准备,从不用统计结束人数队列拖回来
            mapUsersEnd.remove(gameUserExtBean.userId);
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
     *
     * @param userState
     * @param userId
     * @return 1所有用户都告诉比赛结束  0成功
     */
    public int gameUserEnd(String userId,int userState) {
        GameUserExtBean gameUserExtBean = mapUsers.get(userId);
        if(gameUserExtBean!=null){
            synchronized (mapUsersEnd) {
                mapUsersEnd.put(userId, gameUserExtBean);
                gameUserExtBean.state = userState;
                clientVersion++;
                if(mapUsersEnd.size()==userNum){
                    this.state = 2;//比赛结束
                    return 1;
                }
            }
        }
        return 0;
    }

    /**
     * 用户断线
     * 比赛前断线：直接移除,并通知各端
     * 比赛中断线：保留,但设置为断线
     * @param fdtId
     * @param sessionId
     */
    public void disConnectAndAfterRmove(String fdtId, String sessionId) {
        GameUserExtBean gameUserExtBean = mapUsers.get(fdtId);
        if(gameUserExtBean!=null){
            synchronized (this) {
                if(notStart()){
                    //比赛前
                    logger.info("比赛准备中断线fdtId："+fdtId);
                    unReadyUser(fdtId);
                }else{
                    if(gameUserExtBean.state==0) {
                        //用户正常状态断线
                        gameUserExtBean.state = 2;
                        mapUsersEnd.put(fdtId, gameUserExtBean);
                        clientVersion++;
                        logger.info("比赛中断线fdtId：" + fdtId);
                    }
                    if(gameUserExtBean.state==1){
                        logger.info("比赛中确认退出，断线fdtId：" + fdtId);
                    }
                    if(gameUserExtBean.state==3){
                        logger.info("比赛正常退出，断线fdtId：" + fdtId);
                    }
                }
            }
        }
    }

    /**
     * 断线重连，恢复状态
     * @param fdtId
     */
    public void reJoinUser(String fdtId) {
        GameUserExtBean gameUserExtBean = mapUsers.get(fdtId);
        if(gameUserExtBean!=null){
            gameUserExtBean.state = 0;
            mapUsersEnd.remove(fdtId);
            clientVersion++;
            logger.info("断线用户恢复fdtId："+fdtId);
        }
    }

    /**
     * 移除准备中的用户，并且出发通知订阅比赛列表的人
     * @param fdtId
     * @return
     */
    public int unReadyUser(String fdtId) {
        if(mapUsers.containsKey(fdtId)){
            mapUsers.remove(fdtId);
            MatchServiceHelper.xiaoTMatchTopics.readyInfo(gameId);
            return 1;
        }else{
            return -1;
        }
    }

    /**
     * 判断该用户是否可以重连
     * @param userId
     * @return
     */
    public boolean canReConnect(String userId) {
        GameUserExtBean gameUserExtBean = mapUsers.get(userId);
        if(gameUserExtBean!=null){
            if(gameUserExtBean.state ==2 || gameUserExtBean.state == 0){
                return true;
            }
        }
        return false;
    }
    //=============================================================

    /**
     * 根据比赛类型，每秒发送比赛x点位置，直到发完，回收线程
     * @param xiaoTMatchTopics
     * @param drawTimer
     * @param delay  延迟几秒发
     */
    public synchronized void start(XiaoTMatchTopics xiaoTMatchTopics, int drawTimer, int delay) {
        if(state>0){
            return;
        }
        int xPointtemp = 200;//XiaoTMarketType.FC.getType()
        if(tGame.getMarketType()== XiaoTMarketType.SC.getType()){
            xPointtemp = 242;
        }
        int xPoints = xPointtemp;
        clientVersion++;
        state = 1;
        Thread td = new Thread(()->{
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int xNow = 1;
            while(xNow<=xPoints){
                //1.发送本次x坐标
                xiaoTMatchTopics.sendGameTimeLine(gameId,xNow);
                //2.
                ++xNow;
                try {
                    Thread.sleep(drawTimer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //-------------------
            if(state!=2) {
                //正常结束移除数据后，又被这个线程给加入到map里
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(cacheMapXM.get(gameId)!=null) {
                    cacheMapXM.remove(gameId);
                    logger.info(tGame.getGameName()+"__走完比赛3秒后回收");
                    MatchServiceHelper.gameService.endTheGame(this);
                }
            }
        });
        td.setName("game_:"+gameId);
        td.start();
    }


    public boolean notStart() {
        return !startFirst;
    }

    public void startSet() {
        logger.info("比赛开始："+tGame.getGameName());
        startFirst = true;
    }

    /**
     * 比赛结束时如果已经更新完数据库了，就不需要再更新数据库了
     * @return
     */
    public boolean canUpdateDate() {
        return dbUpdateState.get()==0;
    }

    public void hasUpdateDb() {
        dbUpdateState.incrementAndGet();
    }
}
