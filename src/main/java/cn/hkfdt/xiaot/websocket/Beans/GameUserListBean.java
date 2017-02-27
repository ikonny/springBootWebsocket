package cn.hkfdt.xiaot.websocket.Beans;

import cn.hkfdt.xiaot.common.beans.GameUserBean;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;

/**
 * 比赛用户交互对象
 * Created by whyse
 * on 2017/2/24 12:14
 */
public class GameUserListBean extends GameUserBean implements Serializable {
    /**
     * 收益率
     */
    public double returnRate;

    public GameUserListBean deepCopy() {
        GameUserListBean item = new GameUserListBean();
        try {
            BeanUtils.copyProperties(item,this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }
}
