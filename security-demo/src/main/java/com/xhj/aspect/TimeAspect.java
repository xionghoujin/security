package com.xhj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by 熊厚谨 on 2018/5/30 21:57
 *
 * @author 熊厚谨
 */
//@Aspect
//@Component
public class TimeAspect {
    @Around("execution(* UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("time aspect start");
        long timeMillis = System.currentTimeMillis();
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("arg is :" + arg);
        }

        Object proceed = pjp.proceed();
        System.out.println("time aspect 耗时："+(System.currentTimeMillis() - timeMillis));
        System.out.println("time aspect start");
        return proceed;
    }
}
