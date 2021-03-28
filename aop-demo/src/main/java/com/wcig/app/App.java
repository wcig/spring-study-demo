package com.wcig.app;

import com.wcig.app.model.Student;
import com.wcig.app.model.Teacher;
import com.wcig.app.pcd.*;
import com.wcig.app.service.AService;
import com.wcig.app.service.BService;
import com.wcig.app.service.EmailService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
// @EnableAspectJAutoProxy(proxyTargetClass = true)
public class App {
    public static void main( String[] args ) {
        // testAdviceType();

        // testPcdExecution();
        // testPcdWithin();
        // testPcdThis();
        // testPcdTarget();
        // testPcdArgs();
        // testPcdTarget2();
        // testPcdWithin2();
        // testPcdAnnotation();
        // testPcdArgs2();
        // testPcdAnnotationWithArgs();

        // testAopWithFinal();
    }

    // 测试@AspectJ的5种通知类型: @Before,@After,@Around,@AfterReturning,@AfterThrowing
    private static void testAdviceType() {
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

    // 测试切入点指示符PCD: execution
    public static void testPcdExecution() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        ExecutionService service = ctx.getBean(ExecutionService.class);
        service.test();

        // output:
        // [Around] PcdAspect doAround start..
        // ExecutionService test..
        // [Around] PcdAspect doAround end..
    }

    // 测试切入点指示符PCD: within
    public static void testPcdWithin() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        WithinService service = ctx.getBean(WithinService.class);
        service.test1();
        service.test2();

        // output:
        // [Around] PcdAspect doWithin start..
        // WithinService test1..
        // [Around] PcdAspect doWithin end..
        // [Around] PcdAspect doWithin start..
        // WithinService test2..
        // [Around] PcdAspect doWithin end..
    }

    // 测试切入点指示符PCD: this
    public static void testPcdThis() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        IThisService service = ctx.getBean(IThisService.class);
        service.test();

        // output:
        // 1.@EnableAspectJAutoProxy(proxyTargetClass = false)
        // ThisService test..

        // 2.@EnableAspectJAutoProxy(proxyTargetClass = true)
        // [Around] PcdAspect doThis start..
        // ThisService test..
        // [Around] PcdAspect doThis end..
    }

    // 测试切入点指示符PCD: target
    public static void testPcdTarget() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        ITargetService service = ctx.getBean(ITargetService.class);
        service.test();

        // output:
        // [Around] PcdAspect doTarget start..
        // TargetService test..
        // [Around] PcdAspect doTarget end..
    }

    // 测试切入点指示符PCD: args
    public static void testPcdArgs() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        ArgsService service = ctx.getBean(ArgsService.class);
        service.find(100);

        // output:
        // [Around] PcdAspect doArgs start..
        // ArgsService find:100
        // [Around] PcdAspect doArgs end..
    }

    // 测试切入点指示符PCD: @target
    public static void testPcdTarget2() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        Target2Service service = ctx.getBean(Target2Service.class);
        service.test();

        // output:
        // [Around] PcdAspect doTarget2 start..
        // Target2Service test..
        // [Around] PcdAspect doTarget2 end..
    }

    // 测试切入点指示符PCD: @within
    public static void testPcdWithin2() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        Within2Service service = ctx.getBean(Within2Service.class);
        service.test();

        // output:
        // [Around] PcdAspect doWithin2 start..
        // Within2Service test..
        // [Around] PcdAspect doWithin2 end..
    }

    // 测试切入点指示符PCD: @annotation
    public static void testPcdAnnotation() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        AnnotationService service = ctx.getBean(AnnotationService.class);
        service.test();

        // output:
        // [Around] PcdAspect doAnnotation start..
        // AnnotationService test..
        // [Around] PcdAspect doAnnotation end..
    }

    // 测试切入点指示符PCD: @args
    public static void testPcdArgs2() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        Args2Service service = ctx.getBean(Args2Service.class);
        service.test(new Student());
        service.test(new Teacher());

        // output:
        // [Around] PcdAspect doArgs2 start..
        // Args2Service student test..
        // [Around] PcdAspect doArgs2 end..
        // Args2Service teacher test..
    }

    // 切入点指示符PCD: @annotation带参数
    private static void testPcdAnnotationWithArgs() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        BService bService = ctx.getBean(BService.class);
        bService.test();
        // BService test..
        // [MetricTime] test: 8ms
    }

    // spring aop使用时注意final类型
    private static void testAopWithFinal() {
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
