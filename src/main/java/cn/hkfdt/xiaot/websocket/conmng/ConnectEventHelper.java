package cn.hkfdt.xiaot.websocket.conmng;

import cn.hkfdt.xiaot.websocket.service.impl.MatchServiceHelper;
import com.mysql.jdbc.StringUtils;

/**
 * 系统监听到连接断开或者设置情况下会通知相关方法
 * Created by whyse
 * on 2017/3/2 12:17
 */
public class ConnectEventHelper {
    /**
     * 监听到用户断开后回调
     * @param fdtId
     * @param sessionId
     */
    public static void disConnectAndAfterRmove(String fdtId, String sessionId) {
        try{
            if(!StringUtils.isNullOrEmpty(fdtId)) {
                //不为空就断线回收
                MatchServiceHelper.disConnectAndAfterRmove(fdtId, sessionId);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
