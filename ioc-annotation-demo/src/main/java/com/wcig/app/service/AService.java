package com.wcig.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AService {
    // 声明注入方式一: 基于成员变量注入
    @Autowired
    private BService bService;

    // // 声明注入方式二: 基于构造函数注入
    // @Autowired
    // public AService(BService bService) {
    //     this.bService = bService;
    // }

    // // 声明注入方式三: 基于set方法注入
    // @Autowired
    // public void setBService(BService bService) {
    //     this.bService = bService;
    // }

    public void test() {
        System.out.println("AService test..");
        bService.test();
    }
}
