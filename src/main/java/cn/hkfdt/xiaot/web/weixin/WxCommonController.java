package cn.hkfdt.xiaot.web.weixin;

import cn.hkfdt.xiaot.util.SHAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * Created by whyse
 * on 2017/2/21 15:30
 */
@Controller
public class WxCommonController {

    Logger logger = LoggerFactory.getLogger(WxCommonController.class);

    /**
     * 用于微信服务端和本服务认证
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @RequestMapping("/white/wx/server/validate")
    @ResponseBody
    public String validate(@RequestParam(required = true) String signature,
                           @RequestParam(required = true)String timestamp, @RequestParam(required = true)String nonce,
                           @RequestParam(required = true)String echostr) {
//        logger.info("signature:"+signature);
//        logger.info("timestamp:"+timestamp);
//        logger.info("nonce:"+nonce);
//        logger.info("echostr:"+echostr);
        String[] strs = {WXHelper.wxToken,timestamp,nonce};
        Arrays.sort(strs);
        StringBuffer sb = new StringBuffer();
        for(String item : strs){
            sb.append(item);
        }
        String validateStr = SHAUtil.hex_sha1(sb.toString());
//        logger.info("validateStr:"+validateStr);
        if(validateStr.equals(signature)){
            return echostr;
        }
        return "error";
    }
}
