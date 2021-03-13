package com.wcig.app.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class SingletonBean {
    @Autowired
    private PrototypeBean prototypeBean;

    public SingletonBean() {
        System.out.println("Singleton instance created");
    }

    public PrototypeBean getPrototypeBean() {
        System.out.println(LocalTime.now());
        return prototypeBean;
    }
}
