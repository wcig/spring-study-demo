package com.wcig.app.pcd;

import org.springframework.stereotype.Component;

@Component
public class ThisService implements IThisService {
    @Override
    public void test() {
        System.out.println("ThisService test..");
    }
}
