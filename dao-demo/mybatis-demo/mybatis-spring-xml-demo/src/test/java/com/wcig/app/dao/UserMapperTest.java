package com.wcig.app.dao;

import com.wcig.app.MybatisSpringXmlApp;
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
@ContextConfiguration(classes= MybatisSpringXmlApp.class)
@FixMethodOrder(MethodSorters.JVM) // 设置单元测试类的方法执行顺序
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

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
        User user = userMapper.selectByPk(1L);
        log.info("selectById result user: {}", user);
    }

    @Test
    public void testSelectListByName() {
        List<User> userList = userMapper.selectByName("tom");
        log.info("selectListByName result user list: {}", userList);
    }

    @Test
    public void testUpdateById() {
        List<User> userList = userMapper.selectByName("tom");
        if (!userList.isEmpty()) {
            long id = userList.get(0).getId();
            String newPwd = "111111";
            User user = new User();
            user.setId(id);
            user.setPassword(newPwd);
            boolean result = userMapper.updateByPk(user) > 0;
            log.info("updateById result: {}", result);
        }
    }

    @Test
    public void testDeleteById() {
        List<User> userList = userMapper.selectByName("tom");
        if (!userList.isEmpty()) {
            long id = userList.get(0).getId();
            boolean result = userMapper.deleteByPk(id) > 0;
            log.info("updateById result: {}", result);
        }
    }
}
