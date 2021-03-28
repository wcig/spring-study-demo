package com.wcig.app.pcd;

import com.wcig.app.aspect.WithinLog;
import org.springframework.stereotype.Component;

@Component
@WithinLog
public class Within2Service {
    public void test() {
        System.out.println("Within2Service test..");
    }
}
