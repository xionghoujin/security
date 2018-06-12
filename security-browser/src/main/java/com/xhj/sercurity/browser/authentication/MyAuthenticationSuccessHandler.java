package com.xhj.sercurity.browser.authentication;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.xhj.security.core.properties.LoginType;
import com.xhj.security.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 熊厚谨 on 2018/6/5 16:50
 *
 * @author 熊厚谨
 * 自定义登录成功的返回处理
 */
@Component("myAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

            logger.info("登录成功");
            //判断是什么返回的方式
        if (LoginType.jSON.equals(securityProperties.getBrowser().getLoginType())) {
            response.setContentType("application/json;charset=UTF-8");
            //将authentication转换成json格式的字符串，再写进response中
            response.getWriter().write(objectMapper.writeValueAsString(authentication));
        } else {
            //默认的（跳转）
            super.onAuthenticationSuccess(request,response,authentication);
        }



    }
}
