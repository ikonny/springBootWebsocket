package cn.hkfdt.xiaot.web.common.service;

import cn.hkfdt.xiaot.mybatis.model.fxchina.SystemSettings;

import java.util.Map;

/**
 * Created by whyse
 * on 2017/2/13 20:23
 */
public interface CommonService {
    /**
     * @return
     * @author whyse
     * @Date 2017/2/13 20:36
    */
    SystemSettings getSystemSettingValue(String keyCode);
    /**
     * 返回表system_settings 中 value 的map值，如果不合法则空
     * @return
     * @author whyse
     * @Date 2017/2/14 14:46
    */
    Map<String,Object> getSystemSettingValueAsMap(String keyCode);
}
