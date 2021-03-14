package com.wcig.app.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@Configuration
public class DataSourceConfig {

    @Autowired
    Environment environment;

    @Value("${spring.profiles.active}")
    private String activeProfiles;

    @Autowired
    DataSource dataSource;

    public void printCurrentProfile1() {
        String[] profiles = environment.getActiveProfiles();
        System.out.println(Arrays.toString(profiles));
    }

    public void printCurrentProfile2() {
        System.out.println(activeProfiles);
    }

    public void printCurrentDatasource() {
        System.out.println(dataSource);
    }

    @Bean
    @Profile("dev")
    public DataSource devDataSource() {
        return new DataSource("dev");
    }

    @Bean
    @Profile("prod")
    public DataSource prodDataSource() {
        return new DataSource("prod");
    }
}
