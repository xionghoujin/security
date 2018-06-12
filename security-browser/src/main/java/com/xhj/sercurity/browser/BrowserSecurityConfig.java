package com.xhj.sercurity.browser;

import com.xhj.security.core.properties.SecurityProperties;
import com.xhj.security.core.validate.code.ValidateCodeFilter;
import com.xhj.security.core.validate.code.ValidateCodeFilter1;
import com.xhj.sercurity.browser.authentication.MyAuthenticationFailureHandler;
import com.xhj.sercurity.browser.authentication.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by 熊厚谨 on 2018/6/4 19:32
 *
 * @author 熊厚谨
 * security 的配置
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
//        validateCodeFilter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);
//        http    .addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);

        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()//用表单登录
                //设置登录的页面
//                跳转到这个路径（BrowserSecurityController的一个接口的映射地址）
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")//表示提交这个请求的时候使用相应的过滤器进行验证
                .successHandler(myAuthenticationSuccessHandler)//设置登录成功的处理器
                .failureHandler(myAuthenticationFailureHandler)//设置登录失败的处理器
//      http.httpBasic
                .and()
                .authorizeRequests()//表示下面都是授权的配置
                //表示这个路径是允许所有身份权限访问的 不需要下面的身份认证
                .antMatchers("/authentication/require",
                        securityProperties.getBrowser().getLoginPage(),
                        "/code/image"
                ).permitAll()
                .anyRequest()//表示任何请求
                .authenticated()//都需要身份认证
                .and()
                .csrf().disable();

    }
}
