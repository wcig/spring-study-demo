package com.wcig.app.primary;

import com.wcig.app.model.MovieCatalog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PrimaryMovieConfiguration {
    @Bean
    @Primary
    public MovieCatalog firstMovieCatalog() {
        return new MovieCatalog("first movie catalog");
    }

    @Bean
    public MovieCatalog secondMovieCatalog() {
        return new MovieCatalog("second movie catalog");
    }
}
