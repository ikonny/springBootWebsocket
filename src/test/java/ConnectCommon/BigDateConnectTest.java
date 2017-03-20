package ConnectCommon;

import cn.hkfdt.xiaot.mybatis.model.ltschina.TQuestionsNew;
import cn.hkfdt.xiaot.web.xiaot.service.impl.XiaoTHelp;

/**
 * Created by whyse
 * on 2017/3/9 19:01
 */
public class BigDateConnectTest {
    public static void main(String[] args) {
        XiaoTHelp.urlPickTrade = "http://121.43.73.191:8082"+XiaoTHelp.urlPickTrade;
        TQuestionsNew para = XiaoTHelp.getTQuestion("coach-t-guest","FC");
        System.err.println(para);
    }
}
