package cn.hkfdt.xiaot.common.beans;

import java.io.Serializable;

/**
 * 比赛用户交互对象
 * Created by whyse
 * on 2017/2/24 12:14
 */
public class GameUserBean implements Serializable {
    /**
     * 不同的userType，对应不同的id意义
     */
    public String userId;
    /**
     * 昵称
     */
    public String userName;
    /**
     * 参看XiaoTUserType
     * 1,2,3
     */
    public int userType;
    /**
     * 头像
     */
    public String headimgurl;
}
