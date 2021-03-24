package com.wcig.app.service;

import com.wcig.app.aspect.MetricTime;
import org.springframework.stereotype.Component;

@Component
public class BService {
    @MetricTime("test")
    public void test() {
        System.out.println("BService test..");
    }
}
