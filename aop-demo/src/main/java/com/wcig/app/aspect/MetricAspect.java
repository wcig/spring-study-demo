package com.wcig.app.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MetricAspect {

    @Around("@annotation(metricTime)")
    public Object doAround(ProceedingJoinPoint point, MetricTime metricTime) throws Throwable {
        String name = metricTime.value();
        long start = System.currentTimeMillis();
        try {
            return point.proceed();
        } finally {
            long cost = System.currentTimeMillis() - start;
            System.out.printf("[MetricTime] %s: %dms\n", name, cost);
        }
    }

}
