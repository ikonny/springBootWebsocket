package cn.hkfdt.xiaot.web.xiaot.web;

import cn.hkfdt.xiaot.web.Filters.LoginFilter;
import cn.hkfdt.xiaot.web.common.UserContext;
import cn.hkfdt.xiaot.web.common.globalinit.GlobalInfo;
import cn.hkfdt.xiaot.web.weixin.WXHelper;
import cn.hkfdt.xiaot.web.xiaot.service.impl.XiaoTHelp;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by whyse
 * on 2017/2/21 17:07
 */
@Controller
public class XiaotGameController {

    Logger logger = LoggerFactory.getLogger(XiaotGameController.class);

    public static void main(String[] args) {
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("errorCode","201");
        map.put("errorMsg","ss");

        System.err.println(JSON.toJSONString(map));
    }
    /**
     * 二维码扫描的url,后进入比赛准备页面的
     * @param request
     * @return  给比赛准备页面
     */
    @RequestMapping("/xiaoth/game/getUserInfo")
    @ResponseBody
    public String gameIndex(HttpServletRequest request, HttpServletResponse response) {
        if(WXHelper.isFromWx(request)){
//            logger.info("微信:"+GlobalInfo.wxLoginUrl);
            try {
                response.sendRedirect(GlobalInfo.wxLoginUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        String fdtId = UserContext.getUserInfo().get().getFdtId();
        if(LoginFilter.isNotLogin(fdtId)){
            fdtId = XiaoTHelp.xiaoTGuest;
        }
        return "ok";
    }

}
