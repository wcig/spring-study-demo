package com.wcig.app;

import com.wcig.app.service.EmailService;
import com.wcig.app.service.AService;
import com.wcig.app.service.BService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class App {
    public static void main( String[] args ) {
        testAop1();
        testAop2();
        testAop3();
    }

    // 测试@AspectJ的5种通知类型: @Before,@After,@Around,@AfterReturning,@AfterThrowing
    private static void testAop1() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        AService aService = ctx.getBean(AService.class);
        System.out.println("---@AspectJ Before---");
        aService.testBefore();

        System.out.println("---@AspectJ After---");
        aService.testAfter();

        System.out.println("---@AspectJ Around---");
        aService.testAround();

        try {
            System.out.println("---@AspectJ AfterReturning---");
            aService.testAfterReturning1();
            aService.testAfterReturning2();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("---@AspectJ AfterThrowing---");
            aService.testAfterThrowing1();
            aService.testAfterThrowing2();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("---@AspectJ---");
        aService.test();
        // ...
        // ---@AspectJ---
        // [Around] LoggingAspect doAround start..
        // [Before] LoggingAspect doBefore..
        // AService test..
        // [Around] LoggingAspect doAround end..
        // [After] LoggingAspect doAfter..
        // [AfterReturning] LoggingAspect doAfterReturning..
    }

    private static void testAop2() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        BService bService = ctx.getBean(BService.class);
        bService.test();
        // BService test..
        // [MetricTime] test: 8ms
    }

    private static void testAop3() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        EmailService emailService = ctx.getBean(EmailService.class);
        String result = emailService.sendMail();
        System.out.println(result);
        // UserService(): init...
        // UserService(): zoneId = Asia/Shanghai
        // [Before] ProblemAspect doBefore..
        // Hello, it is 2021-03-24T22:46:20.682+08:00[Asia/Shanghai]
    }
}
