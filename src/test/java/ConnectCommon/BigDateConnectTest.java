package ConnectCommon;

import cn.hkfdt.xiaot.mybatis.model.ltschina.TQuestionsNew;
import cn.hkfdt.xiaot.web.xiaot.service.impl.XiaoTHelp;

/**
 * Created by whyse
 * on 2017/3/9 19:01
 */
public class BigDateConnectTest {
    public static void main(String[] args) {
        //http://10.139.168.195:8082
        String pathOnline = "http://192.168.4.139:8082";//192.168.4.139
        String pathOnTest = "http://121.43.73.191:8082";
        XiaoTHelp.urlPickTrade = pathOnline+XiaoTHelp.urlPickTrade;
        //mb000034263   coach-t-guest
        TQuestionsNew para = XiaoTHelp.getTQuestion("mb000034263","SC");
        System.err.println(para);
    }
}
