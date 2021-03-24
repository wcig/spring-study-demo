package com.wcig.app.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public * com.wcig.app.service.AService.*(..))")
    public void doBefore() {
        System.out.println("[Before] LoggingAspect doBefore..");
    }

    @Around("execution(public * com.wcig.app.service.AService.*(..))")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        System.out.println("[Around] LoggingAspect doAround start..");
        Object obj = point.proceed();
        System.out.println("[Around] LoggingAspect doAround end..");
        return obj;
    }

}
