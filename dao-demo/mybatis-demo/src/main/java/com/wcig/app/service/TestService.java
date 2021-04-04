package com.wcig.app.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestService {

    // @Resource
    // private UserMapper userMapper;

    public void test() {
        // String resource = "/Users/yangbo/Documents/MyGithub/spring-study-demo/dao-demo/mybatis-demo/src/main/resources/mybatis-config.xml";
        // try {
        //     InputStream inputStream = Resources.getResourceAsStream(resource);
        //     SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //     SqlSession session = sqlSessionFactory.openSession();
        //     User user = userMapper.selectById(1);
        //     log.info("user: {}", user);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }
}
