package cn.hkfdt.xiaot.web.Filters;

import cn.hkfdt.xiaot.web.common.DeviceContext;
import cn.hkfdt.xiaot.web.common.LogUtil;
import cn.hkfdt.xiaot.web.common.ThreadLocalUserInfo;
import cn.hkfdt.xiaot.web.common.UserContext;
import cn.hkfdt.xiaot.websocket.conmng.WebSocketConnectionListener;
import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.StringUtils;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by whyse
 * on 2017/2/8 14:46
 */
public class LoginFilter implements Filter{

    static String anonym = "anonym";


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest _request, ServletResponse _response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) _request;
        HttpServletResponse response = (HttpServletResponse) _response;

        //load userInfo
        ThreadLocalUserInfo userInfo = new ThreadLocalUserInfo();

        Map<String, String> headersInfo = LoginFilterHelp.getHeadersInfo(request);
        String xToken = headersInfo.get("x-token");

        String token = request.getParameter("auth_token") == null ? xToken : request.getParameter("auth_token");
        if(StringUtils.isNullOrEmpty(token)){
            token =  headersInfo.get("fdt-key");
        }
        String fdtId=anonym;
        if(!StringUtils.isNullOrEmpty(token)){
            fdtId = WebSocketConnectionListener.getFdtId(token,anonym);
            userInfo.setFdtId(fdtId);
        }
        boolean isNotLoginURI = LoginFilterHelp.isNotLoginURI(request);//true就不需要登录检查
        try{
            UserContext.getUserInfo().set(userInfo);
            if(isNotLoginURI){
                chain.doFilter(request,response);
                return;
            }
            //以下是需要登录的url逻辑
            if(fdtId.equals(anonym)){
                responseClient(response,403,"无权限或者没登录");
                return;
            }
            //
            chain.doFilter(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            UserContext.getUserInfo().remove();
        }

    }

    private void responseClient(HttpServletResponse response, int code, String msg) throws IOException {
        Map<String,Object>  map = new HashMap<>(3);
        map.put("code",code);
        map.put("msg",msg);
        String str = DeviceContext.getDeviceInfo().get().toString();
        map.put("dev",str);
        String strTar =JSON.toJSONString(map);
        LogUtil.logSensitive(strTar);

        response.setContentType("application/json; charset=UTF-8");//application/json;text/html
        response.getWriter().println(strTar);
    }

    @Override
    public void destroy() {

    }

    public static boolean isNotLogin(String fdtId) {
        return anonym.equals(fdtId) || StringUtils.isNullOrEmpty(fdtId);
    }
}
