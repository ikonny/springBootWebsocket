package cn.hkfdt.xiaot.websocket.utils;

/**
 * Created by whyse
 * on 2017/2/23 18:51
 */
public class GameUrlHelp {
    /**
     * 监听比赛用户准备信息/gameId
     */
    final public static String topic_userReadyInfo = "/topic/game/readyInfo/";
    /**
     * 请求，客户端准备好了，返回信息是否准备好
     */
    final public static String queue_userDoReady = "/queue/game/doReady";//客户端监听/user/queue/game/doReady
    /**
     * 通知订阅者比赛开始/gameId
     */
    final public static String topic_gameStart = "/topic/game/start/";
    /**
     * 请求，比赛开始，成功就返回相关
     */
    final public static String queue_gameStart = "/queue/game/start";//客户端监听/user/queue/game/start
    /**
     * 通知裁判端所有客户端信息/gameId
     */
    final public static String topic_gameClientInfo = "/topic/game/ClientInfo/";
    /**
     * 通知订阅排行榜的客户端/gameId
     */
    final public static String topic_gameListInfo = "/topic/game/listInfo/";
    /**
     * 请求，发送客户端信息给服务端
     */
    final public static String queue_gameclientInfo = "/queue/game/clientInfo";//客户端监听/user/queue/game/clientInfo

    /**
     * 请求，比赛结束
     */
    final public static String queue_gameOver = "/queue/game/end";//客户端监听/user/queue/game/end
    /**
     * 比赛完全结束后会通知订阅者
     */
    final public static String topic_gameEnd = "/topic/game/end/";
    /**
     * 请求，比赛持续时间
     */
//    final public static String queue_gameStayTime = "/queue/game/stayTime";//客户端监听/user/queue/game/stayTime

    //================================================
}
