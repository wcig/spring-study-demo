package com.wcig.app.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProblemAspect {

    @Before("execution(public * com.wcig.app.service.UserService.*(..))")
    public void doBefore() {
        System.out.println("[Before] ProblemAspect doBefore..");
    }

}
