package cn.hkfdt.xiaot.web.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by whyse
 * on 2017/2/8 15:25
 */
public class LogUtil {
    static Logger logger = LoggerFactory.getLogger("xiaot_sensitive");//

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>(6);
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.parallelStream().forEach((x)->{logSensitive(x);});
    }

    public static void logSensitive(String msg) {
        logger.info(msg);
    }
}
