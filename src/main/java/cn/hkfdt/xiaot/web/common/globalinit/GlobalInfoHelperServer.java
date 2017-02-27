package cn.hkfdt.xiaot.web.common.globalinit;

import cn.hkfdt.xiaot.mybatis.mapper.fxchina.SystemSettingsMapper;
import cn.hkfdt.xiaot.mybatis.model.fxchina.SystemSettings;
import cn.hkfdt.xiaot.mybatis.model.fxchina.SystemSettingsExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.URLEncoder;
import java.util.List;

/**
 * 框架初始化后，将读取数据库或者配置文件配置信息到全局静态变量里面
 * Created by whyse
 * on 2017/2/14 15:58
 */
@Service
public class GlobalInfoHelperServer {
    Logger logger = LoggerFactory.getLogger(GlobalInfoHelperServer.class);
    @Autowired
    SystemSettingsMapper systemSettingsMapper;
    //正确的注入方式，不要忘了配置文件名写错
    @Value("${server.domain}")
    String serverDomain;
    @Value("${redisClient.redisServer}")
    String redisServer;
    @Value("${redisClient.redisPort}")
    int redisPort;
    @Value("${redisClient.redisAuth}")
    String redisAuth;
    @Value("${im.domain}")
    String imDomain;
    @Value("${wx.appid}")
    String wxAppid;
    @Value("${wx.appsecret}")
    String wxAppsecret;
    @Value("${wx.token}")
    String wxToken;
    @Value("${xiaot.game.client.indexurl}")
    String gameClientUrl;//扫码跳转的url
    @Value("${xiaot.game.overtime.minute}")
    int gameOvertimeM;



    @PostConstruct
    public void init(){
        //初始化全局常量数据,配置在数据库里面的
        SystemSettingsExample example = new SystemSettingsExample();
        example.createCriteria().andKeyCodeEqualTo("SSLURI").andTypeEqualTo("Base");
        List<SystemSettings> list = systemSettingsMapper.selectByExample(example);
        GlobalInfo.setBaseSSLUrl(list.get(0).getValue());

        GlobalInfo.redisServer = redisServer;
        GlobalInfo.redisPort = redisPort;
        GlobalInfo.redisAuth = redisAuth;
        GlobalInfo.imDomain = imDomain;
        GlobalInfo.serverDomain = serverDomain;
        //============================================
        GlobalInfo.wxToken = wxToken;
        GlobalInfo.wxAppid = wxAppid;
        String xwRedUrl = "https://"+serverDomain+"/white/wx/getuserinfo_theGameId";
        try {
            xwRedUrl = URLEncoder.encode(xwRedUrl, "utf-8");
        }catch (Exception e){

        }
        GlobalInfo.wxLoginUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+wxAppid+"&redirect_uri=" +
                xwRedUrl + "&response_type=code&scope=snsapi_userinfo&state=xm#wechat_redirect";
        GlobalInfo.wxAppsecret = wxAppsecret;
        //===================================================
        GlobalInfo.gameClientUrl = gameClientUrl;
        GlobalInfo.gameOvertimeM = gameOvertimeM;

    }
}
