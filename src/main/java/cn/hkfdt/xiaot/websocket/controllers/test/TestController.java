package cn.hkfdt.xiaot.websocket.controllers.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by whyse on 2017/1/16.
 */
@Controller
public class TestController {

    //============================================
    @RequestMapping("/ws/test")
//    @ResponseBody
    public String http(String message) {
        System.out.println();
        return "test/nettyws";
    }
}
