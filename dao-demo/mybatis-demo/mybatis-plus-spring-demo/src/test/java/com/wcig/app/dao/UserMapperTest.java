package com.wcig.app.dao;

import com.wcig.app.model.User;
import com.wcig.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:application.xml"})
@FixMethodOrder(MethodSorters.JVM) // 设置单元测试类的方法执行顺序
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;

    @Test
    public void testInsert() {
        User user = new User()
                .setId(1)
                .setName("tom")
                .setPhone("13500001111")
                .setPassword("123456")
                .setCreateTime(System.currentTimeMillis());
        int affected = userMapper.insert(user);
        log.info("insert user success: {}, user: {}", affected == 1, user);
    }

    @Test
    public void testBatchInsert() {
        User u1 = new User()
                .setId(2)
                .setName("tom")
                .setPhone("13500001111")
                .setPassword("123456")
                .setCreateTime(System.currentTimeMillis());
        User u2 = new User()
                .setId(3)
                .setName("tom")
                .setPhone("13500001111")
                .setPassword("123456")
                .setCreateTime(System.currentTimeMillis());
        List<User> list = Arrays.asList(u1, u2);
        boolean result = userService.saveBatch(list);
        log.info("batch save result: {}", result);
    }
}
