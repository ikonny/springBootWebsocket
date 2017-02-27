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
}
