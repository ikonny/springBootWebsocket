package cn.hkfdt.xiaot.web.xiaot.web;

import cn.hkfdt.xiaot.web.weixin.WXHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by whyse
 * on 2017/2/21 17:07
 */
@Controller
public class XiaotGameController {

    Logger logger = LoggerFactory.getLogger(XiaotGameController.class);

    /**
     * 二维码扫描的url,后进入比赛准备页面的
     * @param request
     * @return  给比赛准备页面
     */
    @RequestMapping("/xiaoth/game/index")
    @ResponseBody
    public String gameIndex(HttpServletRequest request) {
        if(WXHelper.isFromWx(request)){
            logger.info("微信");
        }
        return "ok";
    }
}
