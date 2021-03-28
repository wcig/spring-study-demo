package com.wcig.app.model;

import com.wcig.app.aspect.ArgsLog;

@ArgsLog
public class Student implements User {
    @Override
    public String getName() {
        return "student";
    }
}
