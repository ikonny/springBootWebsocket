package cn.hkfdt.xiaot.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by whyse
 * on 2017/2/13 17:32
 */
public class PropertieUtil {
    static Properties propertiesDef = new Properties();
    static final String defPathPro = "extconfig.properties";
    static{
        try {
            String str = PropertieUtil.class.getResource("/").getPath()+defPathPro;
            File file = new File(str);
            propertiesDef.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String key = "admin.houtai";
        String temp = getDefaultProByKey(key);
        System.out.println(temp);
    }
    /**
     * 获取extconfig.properties 配置文件的属性
     * @return
     * @author whyse
     * @Date 2017/2/14 14:37
    */
    public static String getDefaultProByKey(String key) {
        return propertiesDef.get(key).toString();
    }
}
