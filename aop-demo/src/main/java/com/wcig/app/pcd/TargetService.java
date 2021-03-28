package com.wcig.app.pcd;

import org.springframework.stereotype.Component;

@Component
public class TargetService implements ITargetService {
    @Override
    public void test() {
        System.out.println("TargetService test..");
    }
}
