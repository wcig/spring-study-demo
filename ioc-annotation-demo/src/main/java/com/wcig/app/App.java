package com.wcig.app;

import com.wcig.app.primary.PrimaryService;
import com.wcig.app.service.AService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class App {
    public static void main( String[] args ) {
        testIoc();
        testPrimary();
    }

    // 声明方式注入
    private static void testIoc() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        AService a1 = ctx.getBean(AService.class);
        a1.test();
    }

    // @Primary注解: 多个Bean时默认注入的Bean
    private static void testPrimary() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        PrimaryService primaryService = ctx.getBean(PrimaryService.class);
        primaryService.test();
    }
}
