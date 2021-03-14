package com.wcig.app;

import com.wcig.app.event.EmailService;
import com.wcig.app.lifecycle.LifeCycleBean;
import com.wcig.app.primary.PrimaryService;
import com.wcig.app.profile.DataSourceConfig;
import com.wcig.app.qualifier.QualifierService;
import com.wcig.app.required.RequiredAService;
import com.wcig.app.resource.ResourceAService;
import com.wcig.app.scope.PrototypeBean;
import com.wcig.app.scope.SingletonAppContextBean;
import com.wcig.app.scope.SingletonBean;
import com.wcig.app.scope.SingletonLookupBean;
import com.wcig.app.service.AService;
import com.wcig.app.value.DefaultConfig;
import com.wcig.app.value.InjectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @EnableAsync
@Configuration
@ComponentScan
public class App {
    public static void main( String[] args ) {
        testIoc();
        testPrimary();
        testQualifier();
        testResource();
        testScope();
        testInjectPrototypeToSingleton();
        testInjectPrototypeToSingleton1();
        testInjectPrototypeToSingleton2();
        testRequired();
        testLifeCycle();
        testValue();
        testComponent();
        testApplicationEvent();
        testProfile();
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

    // @Scope注解: 定义Bean的范围,默认scope为单例,prototype范围每次获取的Bean为新的实例
    private static void testScope() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        SingletonBean s1 = ctx.getBean(SingletonBean.class);
        SingletonBean s2 = ctx.getBean(SingletonBean.class);
        System.out.println(s1 == s2); // true

        PrototypeBean p1 = ctx.getBean(PrototypeBean.class);
        PrototypeBean p2 = ctx.getBean(PrototypeBean.class);
        System.out.println(p1 == p2); // false
    }

    // 注入Prototype Bean到Singleton Bean中: 如果不做特殊处理注入的Prototype Bean都是同一个实例,prototype scope并没有生效
    private static void testInjectPrototypeToSingleton() {
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

    // 可选注入required参数: 默认是true,不建议使用
    private static void testRequired() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        RequiredAService requiredAService = ctx.getBean(RequiredAService.class);
    }

    // 生命周期lifecycle
    private static void testLifeCycle() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        LifeCycleBean lifeCycleBean = ctx.getBean(LifeCycleBean.class);
    }

    // @Value注解: 从配置文件读取值
    private static void testValue() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        DefaultConfig dc = ctx.getBean(DefaultConfig.class);
        System.out.println(dc);
        InjectConfig ic = ctx.getBean(InjectConfig.class);
        System.out.println(ic);
        ic.test();
    }

    // @Component,@Repository,@Service,@Controller: 4种注解功能类似,只有语意上的区别,分别表名是组件,持久层组件,业务层组件,控制层组件
    private static void testComponent() {
    }

    // ApplicationEvent注册事件: 处理事件可以是同步也可以是异步,需根据实际场景使用
    private static void testApplicationEvent() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        EmailService emailService = ctx.getBean(EmailService.class);
        emailService.sendEmail("a1@example.org", "email content");
    }

    // @Profile注解
    private static void testProfile() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        DataSourceConfig cfg = ctx.getBean(DataSourceConfig.class);
        cfg.printCurrentDatasource();
        cfg.printCurrentProfile1();
        cfg.printCurrentProfile2();
    }
}
