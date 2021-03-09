package com.wcig.app.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QualifierMovieConfiguration {
    @Bean
    @Qualifier("first")
    public QualifierMovieCatalog firstQualifierMovieCatalog() {
        return new QualifierMovieCatalog("first qualifier movie catalog");
    }

    @Bean
    @Qualifier("second")
    public QualifierMovieCatalog secondQualifierMovieCatalog() {
        return new QualifierMovieCatalog("second qualifier movie catalog");
    }
}
