package com.wcig.app.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// lifecycle: Bean Constructor -> PostConstruct -> InitializingBean -> PreDestroy -> DisposableBean
// 推荐使用@PostConstruct,@PreDestroy, 不推荐使用InitializingBean,DisposableBean,容易与Spring耦合
@Component
public class LifeCycleBean implements InitializingBean, DisposableBean {

    public LifeCycleBean() {
        System.out.println("Constructor..");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean afterPropertiesSet..");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy..");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct..");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy..");
    }
}
