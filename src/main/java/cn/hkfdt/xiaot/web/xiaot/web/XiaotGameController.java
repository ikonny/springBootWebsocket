package cn.hkfdt.xiaot.web.xiaot.web;

import cn.hkfdt.xiaot.common.beans.RspCommonBean;
import cn.hkfdt.xiaot.web.common.UserContext;
import cn.hkfdt.xiaot.web.common.globalinit.GlobalInfo;
import cn.hkfdt.xiaot.web.common.meta.GameStatus;
import cn.hkfdt.xiaot.web.weixin.WXHelper;
import cn.hkfdt.xiaot.web.xiaot.service.XiaoTGameService;
import cn.hkfdt.xiaot.web.xiaot.util.XiaoTUserType;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

//        int status = xiaoTGameService.getGameStatus(gameId);
//        if(status == GameStatus.OVER.getStatus()){
//            //TODO: 返回比赛结果
//            return RspCommonBean.getCommonRspBean(301, "比赛已结束");
//        }else if(status == GameStatus.UNDERWAY.getStatus()){
//            return RspCommonBean.getCommonRspBean(302, "比赛已开始");
//        }else if(status == GameStatus.FULL.getStatus()){
//            return RspCommonBean.getCommonRspBean(303, "参赛人数已满");
//        }


        if(WXHelper.isFromWx(request)){//微信用打开
 //           logger.info("微信:"+GlobalInfo.wxLoginUrl);
            try {
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.sendRedirect(GlobalInfo.wxLoginUrl.replace("theGameId", gameId));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        RspCommonBean rcb = RspCommonBean.getCommonRspBean(200, null);
        String fdtId = UserContext.getUserInfo().get().getFdtId();
        Map<String, Object> mapTar = xiaoTGameService.getGameUser(fdtId, gameId);
        rcb.data = mapTar;
        return rcb;
    }

//    @RequestMapping(value = "/xiaoth/game/updateGuestNick")
//    @ResponseBody
//    public Object updateGuestNick(@RequestParam String gameId, @RequestParam String fdtId, @RequestParam String newNick){
//        //TODO: 更新游客昵称
//        RspCommonBean rcb = RspCommonBean.getCommonRspBean(200, null);
//        return rcb;
//    }

    @RequestMapping(value = "/xiaoth/game/create")
    @ResponseBody
    public Object gameCreate(@RequestBody String body) {
        Map<String,Object> mapPara = JSON.parseObject(body);
        RspCommonBean result = xiaoTGameService.gameCreate(mapPara);
        return result;
    }

    /**
     * 查询比赛信息和比赛对应的question信息
     * @param gameId
     * @param type all or history or today
     * @return
     */
    @RequestMapping(value = "/xiaoth/game/getGameInfo")
    @ResponseBody
    public Object getGameInfo(@RequestParam String gameId, @RequestParam(defaultValue = "all") String type){
        return xiaoTGameService.getGameInfo(gameId, type);
    }

    @RequestMapping(value = "/xiaoth/game/getGameResult")
    @ResponseBody
    public Object getGameResult(@RequestParam String gameId){
        return xiaoTGameService.getGameResult(gameId);
    }

}
