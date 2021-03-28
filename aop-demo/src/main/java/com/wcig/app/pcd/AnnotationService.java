package com.wcig.app.pcd;

import com.wcig.app.aspect.AnnotationLog;
import org.springframework.stereotype.Component;

@Component
public class AnnotationService {
    @AnnotationLog
    public void test() {
        System.out.println("AnnotationService test..");
    }
}
