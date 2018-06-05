package com.xhj.sercurity.browser;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by 熊厚谨 on 2018/6/4 19:32
 *
 * @author 熊厚谨
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()//用表单登录
            .and()
            .authorizeRequests()//表示下面都是授权的配置
            .anyRequest()//表示任何请求
            .authenticated();//都需要身份认证
    }
}
