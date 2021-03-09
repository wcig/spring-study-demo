package com.wcig.app.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrimaryService {
    @Autowired
    private PrimaryMovieCatalog primaryMovieCatalog;

    public void test() {
        System.out.println("primary inject: " + primaryMovieCatalog.getName());
    }
}
