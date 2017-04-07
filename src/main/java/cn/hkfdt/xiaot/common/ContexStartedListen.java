package cn.hkfdt.xiaot.common;

import cn.hkfdt.xiaot.web.common.redis.RedisClient;
import cn.hkfdt.xiaot.web.common.service.CommonService;
import cn.hkfdt.xiaot.web.xiaot.service.impl.XiaoTHelp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 框架启动后，可以做一些检测。比如redis
 * Created by whyse
 * on 2017/2/16 16:46
 */
@Component
public class ContexStartedListen  implements ApplicationListener<ContextRefreshedEvent> {
    static Logger logger = LoggerFactory.getLogger(ContexStartedListen.class);
    @Autowired
    CommonService commonService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //防止重复执行。
        if(event.getApplicationContext().getParent() == null){
            Thread td = new Thread(()->{contexStarted();});
            td.setName("系统初始化监控");
            td.start();
        }
    }

    /**
     * 异步，保证这个方法的输出再最后
     */
    private void contexStarted() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        logger.info("===============系统依赖检测开始========================");
//        GlobalInfo.printInfo();
        RedisClient.test();//测试redis是否ok
        commonService.testConnect();
        XiaoTHelp.testRemoteServer();
        logger.info("===============系统依赖检测结束=======================");
    }
}
