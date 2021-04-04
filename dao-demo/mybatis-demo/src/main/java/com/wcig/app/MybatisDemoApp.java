package com.wcig.app;

import com.wcig.app.dao.annotation.UserMapper;
import com.wcig.app.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@ComponentScan
public class MybatisDemoApp {
    public static void main( String[] args ) {
        log.info("mybatis demo application");

        ApplicationContext ctx = new AnnotationConfigApplicationContext(MybatisDemoApp.class);
        UserMapper userMapper = ctx.getBean(UserMapper.class);
        User user = userMapper.selectById(4);
        log.info("result user: {}", user);
    }
}
