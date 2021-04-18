package com.wcig.app;

import com.wcig.app.dao.UserMapper;
import com.wcig.app.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class MybatisQuickStartApp {

    private static SqlSessionFactory sqlSessionFactory;
    static {
        initSqlSessionFactory();
    }

    public static void main(String[] args) throws Exception {
        log.info("mybatis demo application");
        test1();
        test2();
    }

    public static void initSqlSessionFactory() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 推荐使用方式
    public static void test1() {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectById(37L);
        log.info("result user: " + user);
    }

    // 旧版本方式
    public static void test2() {
        SqlSession session = sqlSessionFactory.openSession();
        User user = (User)session.selectOne("com.wcig.app.dao.UserMapper.selectById", 37L);
        log.info("result user: " + user);
    }
}
