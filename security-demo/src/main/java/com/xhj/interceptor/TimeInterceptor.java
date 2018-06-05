package com.xhj.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 熊厚谨 on 2018/5/30 21:14
 *  拦截器
 * @author 熊厚谨
 */
//@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle");

        System.out.println("类名"+((HandlerMethod)o).getBean().getClass().getName());
        System.out.println("方法名"+((HandlerMethod)o).getMethod() .getName());

        httpServletRequest.setAttribute("startTime",System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        Long beforeTime = (Long) httpServletRequest.getAttribute("startTime");
        System.out.println("time interceptor 耗时:"+(System.currentTimeMillis() - beforeTime));

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
        Long beforeTime = (Long) httpServletRequest.getAttribute("startTime");
        System.out.println("time interceptor 耗时:"+(System.currentTimeMillis() - beforeTime));
        System.out.println("ex is " + e);
    }
}
