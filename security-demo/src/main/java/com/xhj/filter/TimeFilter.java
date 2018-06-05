package com.xhj.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by 熊厚谨 on 2018/5/30 19:56
 *  过滤器
 * @author 熊厚谨
 */
//@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("time filter start ");
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("time filter 耗时:"+(System.currentTimeMillis()-start));
        System.out.println("time filter finish ");
    }

    @Override
    public void destroy() {
        System.out.println("time filter destroy");
    }
}
