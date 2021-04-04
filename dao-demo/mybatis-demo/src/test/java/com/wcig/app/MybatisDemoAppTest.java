package com.wcig.app;

import com.wcig.app.dao.FirstMapper;
import com.wcig.app.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class MybatisDemoAppTest {
    @Test
    public void testMybatisSimple() {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            FirstMapper userMapper = session.getMapper(FirstMapper.class);
            User user = userMapper.selectById(4);
            log.info("result user: {}", user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
