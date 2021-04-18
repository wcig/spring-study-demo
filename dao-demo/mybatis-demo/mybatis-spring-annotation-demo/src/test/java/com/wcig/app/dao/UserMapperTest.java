package com.wcig.app.dao;

import com.wcig.app.MybatisSpringAnnotationApp;
import com.wcig.app.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= MybatisSpringAnnotationApp.class)
@FixMethodOrder(MethodSorters.JVM) // 设置单元测试类的方法执行顺序
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testDeleteAll() {
        int num = userMapper.deleteAll();
        log.info("deleteAll user num: {}", num);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("tom");
        user.setPhone("13500001111");
        user.setPassword("123456");
        user.setCreateTime(System.currentTimeMillis());
        boolean result = userMapper.insert(user) > 0;
        log.info("insert user result: {}", result);
    }

    @Test
    public void testInsertUseGeneratedKeys() {
        User user = new User();
        user.setName("jerry");
        user.setPhone("13500002222");
        user.setPassword("123456");
        user.setCreateTime(System.currentTimeMillis());
        boolean result = userMapper.insertUseGeneratedKeys(user) > 0;
        log.info("insertUseGeneratedKeys result:{}, user id: {}", result, user.getId());
    }

    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1L);
        log.info("selectById result user: {}", user);
    }

    @Test
    public void testSelectListByName() {
        List<User> userList = userMapper.selectListByName("tom");
        log.info("selectListByName result user list: {}", userList);
    }

    @Test
    public void testUpdateById() {
        List<User> userList = userMapper.selectListByName("tom");
        if (!userList.isEmpty()) {
            long id = userList.get(0).getId();
            String newPwd = "111111";
            boolean result = userMapper.updateById(newPwd, id) > 0;
            log.info("updateById result: {}", result);
        }
    }

    @Test
    public void testDeleteById() {
        List<User> userList = userMapper.selectListByName("tom");
        if (!userList.isEmpty()) {
            long id = userList.get(0).getId();
            boolean result = userMapper.deleteById(id) > 0;
            log.info("updateById result: {}", result);
        }
    }
}
