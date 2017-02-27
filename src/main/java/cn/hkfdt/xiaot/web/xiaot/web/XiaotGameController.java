package cn.hkfdt.xiaot.web.xiaot.web;

import cn.hkfdt.xiaot.web.common.UserContext;
import cn.hkfdt.xiaot.web.common.globalinit.GlobalInfo;
import cn.hkfdt.xiaot.web.weixin.WXHelper;
import cn.hkfdt.xiaot.web.xiaot.service.XiaoTGameService;
import cn.hkfdt.xiaot.web.xiaot.util.XiaoTUserType;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Autowired
    XiaoTGameService xiaoTGameService;

    public static void main(String[] args) {
        Map<String,Object> map = new LinkedHashMap<>();
        XiaoTUserType.OtherUser.getType();
        map.put("img", "生成二维码图片，返回图片的base64字符串");
        map.put("matchId", "adsffgcsdf");
        map.put("url", "");

        System.err.println(JSON.toJSONString(map));
    }
    /**
     * 二维码扫描的url,后进入比赛准备页面的
     * @param request
     * @return  给比赛准备页面
     */
    @RequestMapping("/xiaoth/game/getUserInfo")
    @ResponseBody
    public Object gameIndex(String gameId,
                            HttpServletRequest request, HttpServletResponse response) {
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
        Map<String,Object> mapTar =  xiaoTGameService.getGameUser(fdtId);
        return mapTar;
    }

    @RequestMapping(value = "/xiaoth/game/create")
    @ResponseBody
    public Object gameCreate(@RequestBody String body) {
        Map<String,Object> mapPara = JSON.parseObject(body);
        Map<String, Object> resultMap = xiaoTGameService.gameCreate(mapPara);
        return resultMap;
    }

}
