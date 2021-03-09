package com.wcig.app.scope;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

// 直接@Resource注入ApplicationContext不实现接口也可以
@Component
public class SingletonAppContextBean implements ApplicationContextAware {

    private ApplicationContext ctx;

    public PrototypeBean getPrototypeBean() {
        return ctx.getBean(PrototypeBean.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }
}
