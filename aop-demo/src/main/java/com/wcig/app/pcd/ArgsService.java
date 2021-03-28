package com.wcig.app.pcd;

import org.springframework.stereotype.Component;

@Component
public class ArgsService {
    public void find(long n) {
        System.out.println("ArgsService find:" + n);
    }
}
