//package com.xhj.security.core.validate.code;
//
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.social.connect.web.HttpSessionSessionStrategy;
//import org.springframework.social.connect.web.SessionStrategy;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.ServletRequestBindingException;
//import org.springframework.web.bind.ServletRequestUtils;
//import org.springframework.web.context.request.ServletWebRequest;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created by 熊厚谨 on 2018/6/11 17:54
// *
// * @author 熊厚谨
// */
//@Component
//public class ValidateCodeFilter1 extends OncePerRequestFilter {
//
//    /**
//     * 验证码校验失败处理器
//     */
//    @Autowired
//    private AuthenticationFailureHandler authenticationFailureHandler;
//
//    /**
//     * session工具类
//     */
//    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        if (StringUtils.equals("/authentication/require", request.getRequestURI())
//                && StringUtils.equalsIgnoreCase(request.getMethod(), "post")) {
//
//            try {
//                Validate(new ServletWebRequest(request));
//            } catch (ValidateCodeException e) {
//                //将错误信息返回
//                authenticationFailureHandler.onAuthenticationFailure(request,response,e);
//            }
//
//        } else {
//            //如果不是 执行后面的的过滤器
//            filterChain.doFilter(request, response);
//        }
//    }
//
//    private void Validate(ServletWebRequest request) throws ServletRequestBindingException {
//
//        ImageCode codeInSession = (ImageCode) sessionStrategy.getAttribute(request,
//                ValidateCodeController.SESSION_KEY);
//
//        String codeInRequest= ServletRequestUtils.getStringParameter(request.getRequest(), "imageCode");
//
//        if (StringUtils.isBlank(codeInRequest)) {
//            throw new ValidateCodeException( "验证码的值不能为空");
//        }
//
//        if (codeInSession == null) {
//            throw new ValidateCodeException("验证码不存在");
//        }
//
//        if (codeInSession.isExpried()) {
//            sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);
//            throw new ValidateCodeException("验证码已过期");
//        }
//
//        if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
//            throw new ValidateCodeException("验证码不匹配");
//        }
//
//        sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);
//    }
//
//    public AuthenticationFailureHandler getAuthenticationFailureHandler() {
//        return authenticationFailureHandler;
//    }
//
//    public ValidateCodeFilter1 setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
//        this.authenticationFailureHandler = authenticationFailureHandler;
//        return this;
//    }
//}
