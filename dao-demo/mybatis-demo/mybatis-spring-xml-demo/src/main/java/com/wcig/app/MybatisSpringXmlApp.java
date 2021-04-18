package com.wcig.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@ComponentScan
public class MybatisSpringXmlApp {
    public static void main( String[] args ) {
        log.info("mybatis spring xml demo");
    }
}
