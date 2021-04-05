package com.wcig.app;

import com.wcig.app.dao.FirstMapper;
import com.wcig.app.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisDemoAppTest {
    // 不使用spring从xml文件中构建SqlSessionFactory
    @Test
    public void testMybatisSimple() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            FirstMapper firstMapper = session.getMapper(FirstMapper.class);
            User user = firstMapper.selectById(37);
            System.out.println("result user: " + user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
