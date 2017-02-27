package cn.hkfdt.xiaot.common.beans;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by whyse
 * on 2017/2/24 12:14
 */
public class ReqCommonBean implements Serializable {
    /**
     * 连接id
     */
    public String sessionId;
    public String fdtId;
    /**
     * 客户端请求的map
     */
    public Map data;

}
