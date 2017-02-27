package cn.hkfdt.xiaot.websocket.Beans;

import cn.hkfdt.xiaot.common.beans.GameUserBean;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;

/**
 * 比赛用户交互对象
 * Created by whyse
 * on 2017/2/24 12:14
 */
public class GameUserExtBean extends GameUserBean implements Serializable {
    public String gameId;
    /**
     * 收益率
     */
    public double returnRate;
    /**
     * 横坐标
     */
    public int curIdx;
    /**
     * 买卖点数据
     * 透传数据
     */
    public Object actions;

    public GameUserExtBean deepCopy() {
        GameUserExtBean item = new GameUserExtBean();
        try {
            BeanUtils.copyProperties(item,this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }
}
