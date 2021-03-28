package com.wcig.app.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PcdAspect {
    // execution: 指定方法执行
    @Pointcut("execution(public void com.wcig.app.pcd.ExecutionService.test())")
    public void executionPointcut(){}

    @Around("executionPointcut()")
    public Object doExecution(ProceedingJoinPoint point) throws Throwable  {
        System.out.println("[Around] PcdAspect doAround start..");
        Object obj = point.proceed();
        System.out.println("[Around] PcdAspect doAround end..");
        return obj;
    }

    // within: 指定类的所有方法执行
    @Pointcut("within(com.wcig.app.pcd.WithinService)")
    public void withinPointcut(){}

    @Around("withinPointcut()")
    public Object doWithin(ProceedingJoinPoint point) throws Throwable  {
        System.out.println("[Around] PcdAspect doWithin start..");
        Object obj = point.proceed();
        System.out.println("[Around] PcdAspect doWithin end..");
        return obj;
    }

    // this:
    @Pointcut("this(com.wcig.app.pcd.ThisService)")
    public void thisPointcut(){}

    @Around("thisPointcut()")
    public Object doThis(ProceedingJoinPoint point) throws Throwable  {
        System.out.println("[Around] PcdAspect doThis start..");
        Object obj = point.proceed();
        System.out.println("[Around] PcdAspect doThis end..");
        return obj;
    }

    // target:
    @Pointcut("target(com.wcig.app.pcd.TargetService)")
    public void targetPointcut(){}

    @Around("targetPointcut()")
    public Object doTarget(ProceedingJoinPoint point) throws Throwable  {
        System.out.println("[Around] PcdAspect doTarget start..");
        Object obj = point.proceed();
        System.out.println("[Around] PcdAspect doTarget end..");
        return obj;
    }

    // args:
    @Pointcut("args(long)")
    public void argsPointcut(){}

    @Around("argsPointcut()")
    public Object doArgs(ProceedingJoinPoint point) throws Throwable  {
        System.out.println("[Around] PcdAspect doArgs start..");
        Object obj = point.proceed();
        System.out.println("[Around] PcdAspect doArgs end..");
        return obj;
    }

    // @target
    @Pointcut("@target(TargetLog)")
    public void target2Pointcut(){}

    @Around("target2Pointcut()")
    public Object doTarget2(ProceedingJoinPoint point) throws Throwable  {
        System.out.println("[Around] PcdAspect doTarget2 start..");
        Object obj = point.proceed();
        System.out.println("[Around] PcdAspect doTarget2 end..");
        return obj;
    }

    // @within
    @Pointcut("@within(WithinLog)")
    public void within2Pointcut(){}

    @Around("within2Pointcut()")
    public Object doWithin2(ProceedingJoinPoint point) throws Throwable  {
        System.out.println("[Around] PcdAspect doWithin2 start..");
        Object obj = point.proceed();
        System.out.println("[Around] PcdAspect doWithin2 end..");
        return obj;
    }

    // @annotation
    @Pointcut("@annotation(AnnotationLog)")
    public void annotationPointcut(){}

    @Around("annotationPointcut()")
    public Object doAnnotation(ProceedingJoinPoint point) throws Throwable  {
        System.out.println("[Around] PcdAspect doAnnotation start..");
        Object obj = point.proceed();
        System.out.println("[Around] PcdAspect doAnnotation end..");
        return obj;
    }

    // @args
    @Pointcut("@args(ArgsLog)")
    public void args2Pointcut(){}

    @Around("args2Pointcut()")
    public Object doArgs2(ProceedingJoinPoint point) throws Throwable  {
        System.out.println("[Around] PcdAspect doArgs2 start..");
        Object obj = point.proceed();
        System.out.println("[Around] PcdAspect doArgs2 end..");
        return obj;
    }
}
