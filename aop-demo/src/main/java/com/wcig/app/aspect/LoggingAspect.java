package com.wcig.app.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(public * com.wcig.app.service.AService.testBefore(..)) || execution(public * com.wcig.app.service.AService.test(..))")
    public void doBefore() {
        System.out.println("[Before] LoggingAspect doBefore..");
    }

    @After("execution(public * com.wcig.app.service.AService.testAfter(..)) || execution(public * com.wcig.app.service.AService.test(..))")
    public void doAfter() {
        System.out.println("[After] LoggingAspect doAfter..");
    }

    @Around("execution(public * com.wcig.app.service.AService.testAround(..)) || execution(public * com.wcig.app.service.AService.test(..))")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        System.out.println("[Around] LoggingAspect doAround start..");
        Object obj = point.proceed();
        System.out.println("[Around] LoggingAspect doAround end..");
        return obj;
    }

    @AfterReturning("execution(public * com.wcig.app.service.AService.testAfterReturning*(..)) || execution(public * com.wcig.app.service.AService.test(..))")
    public void doAfterReturning() {
        System.out.println("[AfterReturning] LoggingAspect doAfterReturning..");
    }

    @AfterThrowing("execution(public * com.wcig.app.service.AService.testAfterThrowing*(..)) || execution(public * com.wcig.app.service.AService.test(..))")
    public void doAfterThrowing() {
        System.out.println("[AfterThrowing] LoggingAspect doAfterThrowing..");
    }
}
