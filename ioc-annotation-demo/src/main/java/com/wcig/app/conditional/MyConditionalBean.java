package com.wcig.app.conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(MyCondition.class)
public class MyConditionalBean {
    public MyConditionalBean() {
        System.out.println("ConditionBean construct..");
    }
}
