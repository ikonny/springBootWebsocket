package cn.hkfdt.xiaot.web.Filters;

import cn.hkfdt.xiaot.util.RequestUtil;
import cn.hkfdt.xiaot.web.common.DeviceContext;
import cn.hkfdt.xiaot.web.common.DeviceInfo;
import cn.hkfdt.xiaot.web.common.LogUtil;
import cn.hkfdt.xiaot.web.common.meta.HttpHeader;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * DeviceContext.getDeviceInfo().get() : 使能获取到设备
 * Created by whyse
 * on 2017/2/8 14:46
 */
//@WebFilter(filterName="myFilter",urlPatterns="/*")  //无法控制顺序所以不使用
public class DeviceFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest _request, ServletResponse _response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) _request;
        HttpServletResponse response = (HttpServletResponse) _response;

        DeviceInfo deviceInfo = new DeviceInfo();
        HttpHeader head = parseRequest(request);
        if (head != null) {
            //load deviceInfo
            deviceInfo.setClientVersion(head.getClientVersion());

            if (head.getAppNameEnum() != null) {
                deviceInfo.setAppName(head.getAppNameEnum());
            }
            deviceInfo.setChannel(head.getChannel());
            deviceInfo.setIp(RequestUtil.getIP(request));
            deviceInfo.setLang(head.getLanguage());
            deviceInfo.setDid(head.getDeviceId());
            deviceInfo.setSysVersion(head.getSysVersion());
            if (head.getDeviceEnum() != null) {
                deviceInfo.setDeviceName(head.getDeviceEnum().getName());
            }
            DeviceContext.getDeviceInfo().set(deviceInfo);
        } else {
            DeviceContext.getDeviceInfo().set(deviceInfo);
        }

        LogUtil.logSensitive(DeviceContext.getDeviceInfo().get().toString());//测试代码

        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            LogUtil.logSensitive("some error happend");
        } finally {
            DeviceContext.getDeviceInfo().remove();
        }

    }
    private HttpHeader parseRequest(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        String fdtInfo = request.getHeader("Fdt-Info");
        String fdtDid = request.getHeader("Fdt-Did");
        String lang = request.getHeader("x-language");
        try {
            return RequestUtil.extractHttpHeader(userAgent, fdtInfo, fdtDid, lang);
        } catch (Exception e) {
            LogUtil.logSensitive("device extract error, the head is {}"+ userAgent+fdtInfo+fdtDid);
            return null;
        }
    }

    @Override
    public void destroy() {

    }
}
