package com.wcig.app.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PrimaryMovieConfiguration {
    @Bean
    @Primary
    public PrimaryMovieCatalog firstPrimaryMovieCatalog() {
        return new PrimaryMovieCatalog("first primary movie catalog");
    }

    @Bean
    public PrimaryMovieCatalog secondPrimaryMovieCatalog() {
        return new PrimaryMovieCatalog("second primary movie catalog");
    }
}
