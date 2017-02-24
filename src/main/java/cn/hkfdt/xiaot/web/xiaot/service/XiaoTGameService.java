package cn.hkfdt.xiaot.web.xiaot.service;


import java.util.Map;

public interface XiaoTGameService {

    Map<String,Object> getGameUser(String fdtId);

    /**
     * @param mapPara {"userNum":10,"gameName":"aa对抗赛","marketType":0}
     * @return {"errorCode":"201","errorMsg":"ss"}
     */
    Map<String,Object> gameCreate(Map<String, Object> mapPara);
}
