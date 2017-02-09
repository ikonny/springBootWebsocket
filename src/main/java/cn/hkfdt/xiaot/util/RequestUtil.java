package cn.hkfdt.xiaot.util;


import cn.hkfdt.xiaot.web.common.meta.AppNameEnum;
import cn.hkfdt.xiaot.web.common.meta.DeviceEnum;
import cn.hkfdt.xiaot.web.common.meta.HttpHeader;
import com.mysql.jdbc.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhaopingfei on 2015/11/2.
 * Powered by Rock
 */
public class RequestUtil {

    private static final String USERAGENTPATTERN = ".*?/(.*?)\\s+\\((.*?)(:|;).*";
    private static final String USERAGENTPATTERN_WEBVIEW = ".*?fdt_version/(.*?)$";
    private static Pattern userAgentPattern = Pattern.compile(USERAGENTPATTERN);
    private static Pattern userAgentWebViewPattern = Pattern.compile(USERAGENTPATTERN_WEBVIEW);

    private static final String FDTINFO_PATTERN = "(.*)\\((.*?);(.*?);(.*?);(.*?);(.*?);(.*?)\\)";
    private static Pattern fdtInfoPattern = Pattern.compile(FDTINFO_PATTERN);

    private static final String FDTID_PATTERN = "\\((.*?)\\)";
    private static Pattern fdtIdPattern = Pattern.compile(FDTID_PATTERN);

    /**
     * 获得用户的访问ip
     *
     * @param request
     * @return
     */
    public static String getIP(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (!StringUtils.isNullOrEmpty(ip) && ip.indexOf(',') > -1) {
            String[] array = ip.split(",");
            if (array.length > 1) {
                ip = array[1].trim();
            }
        }
        return ip;
    }


    public static String getDeepLinkPrefix(String language) {
        if ("CN".equalsIgnoreCase(language)) {
            return "forexmastercn";
        } else if ("TW".equalsIgnoreCase(language)) {
            return "forexmastertw";
        } else {
            return "forexmaster";
        }
    }

    public static String getDefaultImgIfNotExist(String image) {
        if (StringUtils.isNullOrEmpty(image)) {
            return "http://img.investmaster.cn/defaultavatar.png";
        }

        return image;
    }

    public static HttpHeader extractHttpHeader(String userAgent, String fdtInfo, String fdtDid, String lang) {
        HttpHeader header = new HttpHeader();
        if (!StringUtils.isNullOrEmpty(userAgent)) {
            if(!userAgent.contains("fdt_version")){
                Matcher matcher = userAgentPattern.matcher(userAgent);
                if (matcher.find()) {
                    String clientVersion = matcher.group(1);
                    String device = matcher.group(2);
                    header.setClientVersion(clientVersion);
                    header.setDeviceEnum(DeviceEnum.getEnumByDevice(device));
                }
            }else{
                Matcher newMatcher = userAgentWebViewPattern.matcher(userAgent);
                if (newMatcher.find()) {
                    if (userAgent.contains("Mac")) {
                        header.setDeviceEnum(DeviceEnum.IPHONE);
                    }else{
                        header.setDeviceEnum(DeviceEnum.ANDROID);
                    }
                    header.setClientVersion(newMatcher.group(1));
                }
            }
        }

        if (!StringUtils.isNullOrEmpty(fdtInfo)) {
            Matcher infoMatcher = fdtInfoPattern.matcher(fdtInfo);
            if (infoMatcher.find()) {
                String appName = infoMatcher.group(1);
                AppNameEnum nameEnum = AppNameEnum.getEnumByFullName(appName);
                //String deviceType = infoMatcher.group(2);
                String screenSize = infoMatcher.group(3);
                String density = infoMatcher.group(4);
                String language = infoMatcher.group(5);
                String channel = infoMatcher.group(6);
                String sysVersion = infoMatcher.group(7);

                header.setAppNameEnum(nameEnum);
                header.setLanguage(language);
                header.setDensity(density);
                header.setScreenSize(screenSize);
                header.setChannel(channel);
                header.setSysVersion(sysVersion);
            }
        }

        if (!StringUtils.isNullOrEmpty(lang))
        {
            header.setLanguage(lang);
        }

        if (!StringUtils.isNullOrEmpty(fdtDid))
        {
            Matcher idMatcher = fdtIdPattern.matcher(fdtDid);
            if (idMatcher.find()) {
                String did = idMatcher.group(1);
                header.setDeviceId(did);
            } else {
                header.setDeviceId(fdtDid);
            }
        }

        if (header.getAppNameEnum() == null)
        {
            header.setAppNameEnum(AppNameEnum.FOREXMASTER);
        }
        return header;
    }

    /**
     * 获取当前域名 http://localhost/im
     * @param request
     * @return
     * author:xumin 
     * 2016-12-7 下午8:27:43
     */
	public static String getDName(HttpServletRequest request) {
		String schema = request.getHeader("X-Forwarded-Proto") == 
				null ? request.getScheme() : request.getHeader("X-Forwarded-Proto");
        String apiBaseFullUrl = schema + "://" + request.getServerName() + request.getContextPath();
		return apiBaseFullUrl;
	}
}
