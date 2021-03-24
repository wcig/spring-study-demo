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

    private static void testAop1() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        AService aService = ctx.getBean(AService.class);
        aService.test();
        // [Around] LoggingAspect doAround start..
        // [Before] LoggingAspect doBefore..
        // AService test..
        // [Around] LoggingAspect doAround end..
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
