package cn.hkfdt.xiaot.web.common.globalinit;

import cn.hkfdt.xiaot.mybatis.mapper.fxchina.SystemSettingsMapper;
import cn.hkfdt.xiaot.mybatis.model.fxchina.SystemSettings;
import cn.hkfdt.xiaot.mybatis.model.fxchina.SystemSettingsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 框架初始化后，将读取数据库或者配置文件配置信息到全局静态变量里面
 * Created by whyse
 * on 2017/2/14 15:58
 */
@Service
public class GlobalInfoHelperServer {
    @Autowired
    SystemSettingsMapper systemSettingsMapper;
    //正确的注入方式，不要忘了配置文件名写错
    @Value("${server.domain.http}")
    String domainHttp;

    @PostConstruct
    public void init(){
        //初始化全局常量数据,配置在数据库里面的
        SystemSettingsExample example = new SystemSettingsExample();
        example.createCriteria().andKeyCodeEqualTo("SSLURI").andTypeEqualTo("Base");
        List<SystemSettings> list = systemSettingsMapper.selectByExample(example);
        GlobalInfo.setBaseSSLUrl(list.get(0).getValue());

        GlobalInfo.setDomainHttp(domainHttp);
    }
}
