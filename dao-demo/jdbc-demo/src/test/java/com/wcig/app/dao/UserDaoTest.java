package com.wcig.app.dao;

import com.wcig.app.App;
import com.wcig.app.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= App.class)
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("jerry");
        user.setPhone("13500002222");
        user.setPassword("123456");
        user.setCreateTime(System.currentTimeMillis());
        boolean result = userDao.insert(user);
        log.info("insert user result: {}", result);
    }

    @Test
    public void testSelectById() {
        long id = 1L;
        User user = userDao.selectById(id);
        log.info("select by id, user: {}", user);
    }

}
