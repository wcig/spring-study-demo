package com.wcig.app;

import com.wcig.app.service.AService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ) {
        testApplicationContext();
        testBeanFactory();
    }

    // xml方式注入: 支持基于构造函数注入+基于set方法注入
    // 通过ApplicationContext获取Bean
    private static void testApplicationContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        AService a1 = context.getBean(AService.class);
        a1.test();
        AService a2 = (AService) context.getBean("aService");
        System.out.println(a1 == a2); // true
    }

    // 通过BeanFactory获取Bean
    private static void testBeanFactory() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("application.xml");
        AService a1 = beanFactory.getBean(AService.class);
        a1.test();
        AService a2 = (AService) beanFactory.getBean("aService");
        System.out.println(a1 == a2); // true
    }
}
