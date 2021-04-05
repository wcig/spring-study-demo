package com.wcig.app.dao.sqmple;

import com.wcig.app.MybatisDemoApp;
import com.wcig.app.dao.sample.InsertMapper;
import com.wcig.app.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= MybatisDemoApp.class)
@FixMethodOrder(MethodSorters.JVM) // 设置单元测试类的方法执行顺序
public class InsertMapperTest {

    @Resource
    private InsertMapper mapper;

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("tom");
        user.setPhone("13500001111");
        user.setPassword("123456");
        user.setCreateTime(System.currentTimeMillis());
        boolean result = mapper.insert(user) > 0;
        log.info("insert user result: {}", result);
    }

    @Test
    public void testInsertUseGeneratedKeys() {
        User user = new User();
        user.setName("jerry");
        user.setPhone("13500002222");
        user.setPassword("123456");
        user.setCreateTime(System.currentTimeMillis());
        boolean result = mapper.insertUseGeneratedKeys(user) > 0;
        log.info("insertUseGeneratedKeys result:{}, user id: {}", result, user.getId());
    }
}
