package cn.hkfdt.xiaot.web.xiaot.service;


import cn.hkfdt.xiaot.common.beans.RspCommonBean;

import java.util.Map;

public interface XiaoTGameService {

    Map<String,Object> getGameUser(String fdtId, String gameId);

    /**
     * @param mapPara {"userNum":10,"gameName":"aa对抗赛","marketType":0}
     * @return {"errorCode":"201","errorMsg":"ss"}
     */
    RspCommonBean gameCreate(Map<String, Object> mapPara);


    /**
     * 获取比赛状态
     * @param gameId
     * @return 0:未开始  1:进行中  2:结束  3:已满员
     */
    int getGameStatus(String gameId);

    /**
     * 获取比赛信息
     * @param gameId
     * @return
     */
    RspCommonBean getGameInfo(String gameId, String type);

    /**
     * 获取比赛结果
     * @param gameId
     * @return
     */
    RspCommonBean getGameResult(String gameId);
}
