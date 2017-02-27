package cn.hkfdt.xiaot.common.beans;

import java.io.Serializable;

/**
 * Created by whyse
 * on 2017/2/24 12:14
 */
public class RspCommonBean implements Serializable {
    /**
     * 返回码，200正确,其他错误
     */
    public int rspCode;
    /**
     * 返回语
     */
    public String msg;
    /**
     * 成功情况下返回的数据
     */
    public Object data;

    public static RspCommonBean getCommonRspBean(int rspCode,String msg){
        RspCommonBean item = new RspCommonBean();
        item.rspCode = rspCode;
        item.msg = msg;
        return item;
    }
}
