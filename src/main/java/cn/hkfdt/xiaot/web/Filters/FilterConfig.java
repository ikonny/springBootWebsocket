package cn.hkfdt.xiaot.web.Filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤素有xiaoth开头的url,代表http的过滤器
 * Created by whyse
 * on 2017/2/7 10:40
 */
@Configuration
public class FilterConfig extends WebMvcConfigurerAdapter {

    @Bean
    public FilterRegistrationBean greetingFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("deviceFilter");
        DeviceFilter deviceFilter = new DeviceFilter();
        registrationBean.setFilter(deviceFilter);
        registrationBean.setOrder(1);
        List<String> urlList = new ArrayList<>();
        urlList.add("/xiaoth/*");
        registrationBean.setUrlPatterns(urlList);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean helloFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("loginFilter");
        LoginFilter loginFilter = new LoginFilter();
        registrationBean.setFilter(loginFilter);
        registrationBean.setOrder(2);
        List<String> urlList = new ArrayList<>();
        urlList.add("/xiaoth/*");
        registrationBean.setUrlPatterns(urlList);
        return registrationBean;
    }
}
