package cn.hkfdt.xiaot.web.common.service.impl;

import cn.hkfdt.xiaot.mybatis.mapper.fxchina.SystemSettingsMapper;
import cn.hkfdt.xiaot.mybatis.model.fxchina.SystemSettings;
import cn.hkfdt.xiaot.mybatis.model.fxchina.SystemSettingsExample;
import cn.hkfdt.xiaot.web.common.service.CommonService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by whyse
 * on 2017/2/13 20:24
 */
@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    SystemSettingsMapper systemSettingsMapper;

    @Override
    public SystemSettings getSystemSettingValue(String keyCode) {

        SystemSettingsExample example = new SystemSettingsExample();
        example.createCriteria().andKeyCodeEqualTo(keyCode);
        List<SystemSettings> list = systemSettingsMapper.selectByExample(example);
        return list.isEmpty()?null:list.get(0);
    }

    @Override
    public Map<String, Object> getSystemSettingValueAsMap(String keyCode) {
        SystemSettings item  = getSystemSettingValue(keyCode);
        try{
            String jsonStr = item.getValue();
            return JSON.parseObject(jsonStr);
        }catch (Exception e){
            return null;
        }
    }
}
