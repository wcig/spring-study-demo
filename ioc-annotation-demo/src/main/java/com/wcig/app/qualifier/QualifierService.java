package com.wcig.app.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class QualifierService {
    @Autowired
    @Qualifier("first")
    private QualifierMovieCatalog firstMovieCatalog;

    @Autowired
    @Qualifier("second")
    private QualifierMovieCatalog secondMovieCatalog;

    public void test() {
        System.out.println("success inject: " + firstMovieCatalog.getName() + ", " + secondMovieCatalog.getName());
    }
}
