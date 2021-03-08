package com.wcig.app.service;

public class AService {
    private BService bService;

    // 通过set方法注入
    public void setBService(BService bService) {
        this.bService = bService;
    }

    public void test() {
        System.out.println("AService test..");
        bService.test();
    }
}
