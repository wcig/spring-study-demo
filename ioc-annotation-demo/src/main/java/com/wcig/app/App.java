package com.wcig.app;

import com.wcig.app.primary.PrimaryService;
import com.wcig.app.qualifier.QualifierService;
import com.wcig.app.required.RequiredAService;
import com.wcig.app.resource.ResourceAService;
import com.wcig.app.scope.*;
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
        testQualifier();
        testResource();
        testScope();
        testInjectPrototypeToSingleton1();
        testInjectPrototypeToSingleton2();
        testRequired();
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

    // @Qualifier注解: 多个Bean时可定义该注解区分注入对应的Bean
    private static void testQualifier() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        QualifierService qualifierService = ctx.getBean(QualifierService.class);
        qualifierService.test();
    }

    // @Resource注解: 几乎等价于@Autowired
    // @Autowired,@Resource区别: 功能都是注入Bean,区别在与:1)适用范围不同;2)来源不同,前者是spring后者是java注解;3)注入规则不同,前者先byType,指定了Qualifier则byName,后者byName->byType->byName,byType
    private static void testResource() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        ResourceAService resourceAService = ctx.getBean(ResourceAService.class);
        resourceAService.test();
    }

    // @Scope注解: 定义Bean的范围,默认scope为单例
    private static void testScope() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        SingletonBean firstSingleton = ctx.getBean(SingletonBean.class);
        PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();

        // get singleton bean instance one more time
        SingletonBean secondSingleton = ctx.getBean(SingletonBean.class);
        PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();

        System.out.println(firstPrototype.equals(secondPrototype)); // true
    }

    // 注入Prototype Bean到Singleton Bean中: 注入ApplicationContext
    // 参考: https://www.baeldung.com/spring-inject-prototype-bean-into-singleton
    private static void testInjectPrototypeToSingleton1() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        SingletonAppContextBean s1 = ctx.getBean(SingletonAppContextBean.class);
        PrototypeBean p1 = s1.getPrototypeBean();

        SingletonAppContextBean s2 = ctx.getBean(SingletonAppContextBean.class);
        PrototypeBean p2 = s2.getPrototypeBean();
        System.out.println(p1 == p2); // false
    }

    // 注入Prototype Bean到Singleton Bean中: @Lookup方法注入
    private static void testInjectPrototypeToSingleton2() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        SingletonLookupBean s1 = ctx.getBean(SingletonLookupBean.class);
        PrototypeBean p1 = s1.getPrototypeBean();

        SingletonLookupBean s2 = ctx.getBean(SingletonLookupBean.class);
        PrototypeBean p2 = s2.getPrototypeBean();
        System.out.println(p1 == p2); // false
    }

    // required参数: 默认是true,不建议使用
    private static void testRequired() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        RequiredAService requiredAService = ctx.getBean(RequiredAService.class);
    }
}
