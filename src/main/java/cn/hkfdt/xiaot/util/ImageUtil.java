package cn.hkfdt.xiaot.util;


import com.mysql.jdbc.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaopingfei on 2015/10/27.
 * Powered by Rock
 */
public class ImageUtil {

    static final Map<String, String> IMAGEMAP = new HashMap<>();
    static final Map<String, String> ENVMAP = new HashMap<>();


    static {
        IMAGEMAP.put("forexmasterdev.oss-cn-beijing.aliyuncs.com", "devimg.investmaster.cn");
        IMAGEMAP.put("forexmastertest.oss-cn-beijing.aliyuncs.com", "testimg.investmaster.cn");
        IMAGEMAP.put("forexmasteruat.oss-cn-beijing.aliyuncs.com", "uat.img.investmaster.cn");
        IMAGEMAP.put("forexmaster.oss-cn-beijing.aliyuncs.com", "img.investmaster.cn");

        IMAGEMAP.put("fdtglobaldev.oss-cn-beijing.aliyuncs.com", "dev.img.investmaster.io");
        IMAGEMAP.put("fdtglobaltest.oss-cn-beijing.aliyuncs.com", "test.img.investmaster.io");
        IMAGEMAP.put("fdtglobaluat.oss-cn-beijing.aliyuncs.com", "uat.img.investmaster.io");
        IMAGEMAP.put("fdtglobal.oss-cn-beijing.aliyuncs.com", "img.investmaster.io");

        ENVMAP.put("dev-cn", "http://forexmasterdev.oss-cn-beijing.aliyuncs.com");
        ENVMAP.put("test-cn", "http://forexmastertest.oss-cn-beijing.aliyuncs.com");
        ENVMAP.put("uat-cn", "http://forexmasteruat.oss-cn-beijing.aliyuncs.com");
        ENVMAP.put("online-cn", "http://forexmaster.oss-cn-beijing.aliyuncs.com");
        ENVMAP.put("dev-en", "http://fdtglobaldev.oss-cn-beijing.aliyuncs.com");
        ENVMAP.put("test-en", "http://fdtglobaltest.oss-cn-beijing.aliyuncs.com");
        ENVMAP.put("uat-en", "http://fdtglobaluat.oss-cn-beijing.aliyuncs.com");
        ENVMAP.put("online-en", "http://fdtglobal.oss-cn-beijing.aliyuncs.com");
    }

    public static String getPicPrefix(String key) {
        String prefix = "http://forexmasteruat.oss-cn-beijing.aliyuncs.com";
        if (!StringUtils.isNullOrEmpty(key)) {
            String tempPrefix = ENVMAP.get(key.toLowerCase());
            if (tempPrefix != null) {
                return tempPrefix;
            }
        }
        return prefix;
    }

    public static String transImage(String dbUrl) {
        if (StringUtils.isNullOrEmpty(dbUrl)) {
            return "";
        }
        for (String key : IMAGEMAP.keySet()) {
            if (dbUrl.contains(key)) {
                return dbUrl.replace(key, IMAGEMAP.get(key));
            }
        }
        return dbUrl;
    }

    /**
     * 转换cdn链接，处理微信qq头像地址错误，压缩图片
     * @param dbUrl 图片url
     * @param h 压缩高度
     * @param w 压缩宽度
     * @return
     */
    public static String transAndResizeImg(String dbUrl, int h, int w){
        if (StringUtils.isNullOrEmpty(dbUrl)) {
            return "";
        }
        dbUrl = operPicURL(dbUrl);

        for (String key : IMAGEMAP.keySet()) {
            if (dbUrl.contains(key)) {
                return dbUrl.replace(key, IMAGEMAP.get(key));
            }
        }
        //处理微信qq错误头像
        if(dbUrl.contains("/http://")){
            dbUrl = dbUrl.substring(dbUrl.indexOf("/http://")+1);
        }
        //压缩
        if(dbUrl.contains("investmaster")){
            dbUrl+="@"+h+"h_"+w+"w";
        }

        return dbUrl;
    }

    private static String operPicURL(String picUil) {
        if (StringUtils.isNullOrEmpty(picUil)) {
            return picUil;
        }
        if (picUil.toLowerCase().endsWith(".jpg"))
            picUil = ImageUtil.transImage(picUil) + "@90q";
        else
            picUil = ImageUtil.transImage(picUil);
        // 协议改成相对的
        picUil = picUil.replaceFirst("^(https?)://", "//");
        return picUil;
    }

}
