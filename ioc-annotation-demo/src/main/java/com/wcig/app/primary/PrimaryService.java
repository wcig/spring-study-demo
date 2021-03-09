package com.wcig.app.primary;

import com.wcig.app.model.MovieCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrimaryService {
    @Autowired
    private MovieCatalog movieCatalog;

    public void test() {
        System.out.println("primary test: " + movieCatalog.getName());
    }
}
