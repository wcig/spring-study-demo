package com.wcig.app.resource;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ResourceAService {
    @Resource
    private ResourceBService resourceBService;

    public void test() {
        System.out.println("ResourceAService test..");
        resourceBService.test();
    }
}
