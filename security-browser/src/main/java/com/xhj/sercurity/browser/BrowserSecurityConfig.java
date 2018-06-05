package com.xhj.sercurity.browser;

import com.xhj.security.core.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by 熊厚谨 on 2018/6/4 19:32
 *
 * @author 熊厚谨
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()//用表单登录
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")//表示提交这个请求的时候使用相应的过滤器进行验证
//      http.httpBasic
                .and()
                .authorizeRequests()//表示下面都是授权的配置
                //表示这个路径是允许所有身份权限访问的 不需要下面的身份认证
                .antMatchers("/authentication/require",
                        securityProperties.getBrowser().getLoginPage()).permitAll()
                .anyRequest()//表示任何请求
                .authenticated()//都需要身份认证
                .and()
                .csrf().disable();

    }
}
