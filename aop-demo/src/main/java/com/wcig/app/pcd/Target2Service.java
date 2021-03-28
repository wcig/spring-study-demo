package com.wcig.app.pcd;

import com.wcig.app.aspect.TargetLog;
import org.springframework.stereotype.Component;

@Component
@TargetLog
public class Target2Service {
    public void test() {
        System.out.println("Target2Service test..");
    }
}
