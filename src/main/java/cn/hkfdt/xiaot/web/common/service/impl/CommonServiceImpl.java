package cn.hkfdt.xiaot.web.common.service.impl;

import cn.hkfdt.xiaot.mybatis.mapper.fxchina.SystemSettingsMapper;
import cn.hkfdt.xiaot.mybatis.mapper.ltschina.TQuestionsNewExtendsMapper;
import cn.hkfdt.xiaot.mybatis.model.fxchina.SystemSettings;
import cn.hkfdt.xiaot.mybatis.model.fxchina.SystemSettingsExample;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TQuestionsNew;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TQuestionsNewExample;
import cn.hkfdt.xiaot.web.common.LogUtil;
import cn.hkfdt.xiaot.web.common.service.CommonService;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    static Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);
    @Autowired
    SystemSettingsMapper systemSettingsMapper;
    @Autowired
    TQuestionsNewExtendsMapper tQuestionsNewExtendsMapper;

    @Override
    public void testConnect() {
        try {
            TQuestionsNewExample example = new TQuestionsNewExample();
//        example.setOrderByClause( " *** desc");
            RowBounds tq = new RowBounds(0, 1);
            List<TQuestionsNew> list = tQuestionsNewExtendsMapper.selectByExampleWithRowbounds(example, tq);
            if(!list.isEmpty()){
                logger.info("lts_china DB OK");
            }else{
                LogUtil.logSensitive("lts_china DB bad!!!!");
            }
            SystemSettingsExample sysExample = new SystemSettingsExample();
            List<SystemSettings> lists = systemSettingsMapper.selectByExampleWithRowbounds(sysExample, tq);
            if(!lists.isEmpty()){
                logger.info("lts_fx DB OK");
            }else{
                LogUtil.logSensitive("lts_fx DB bad!!!!");
            }
        }catch (Exception e){
            e.printStackTrace();
            LogUtil.logSensitive("DB bad!!!!");
        }
    }
    //=================================================
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
