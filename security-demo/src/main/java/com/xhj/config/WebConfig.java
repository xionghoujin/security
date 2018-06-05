package com.xhj.config;

import com.xhj.interceptor.TimeInterceptor;
import com.xhj.filter.TimeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 熊厚谨 on 2018/5/30 20:06
 *
 * @author 熊厚谨
 */
//告诉spring这是一个配置类
//@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
    @Autowired
    private TimeInterceptor timeInterceptor;

//    注册可以拦截异步请求的拦截器
//    @Override
//    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//
//    }

    //在不使用@Component配置filter的时候另一种的配置方法（spring boot 没有web.xml的配置文件 ）
    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        registrationBean.setFilter(timeFilter);

        List<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);
        return registrationBean;
    }

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }
}
