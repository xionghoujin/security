package com.xhj.sercurity.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xhj.security.core.properties.LoginType;
import com.xhj.security.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 熊厚谨 on 2018/6/5 17:32
 *自定义登录失败的返回
 * @author 熊厚谨
 */
@Component("myAuthenticationFailureHandler")
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        logger.info("登录失败");

        //判断是什么返回的方式
        if (LoginType.jSON.equals(securityProperties.getBrowser().getLoginType())) {
                response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
                response.setContentType("application/json;charset=UTF-8");
                //将authentication转换成json格式的字符串，再写进response中
                response.getWriter().write(objectMapper.writeValueAsString(e));
        } else {
            //默认的（跳转）
            super.onAuthenticationFailure(request,response,e);
        }
    }
}
