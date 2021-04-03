package com.wcig.app.dao;

import com.wcig.app.App;
import com.wcig.app.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= App.class)
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void testInsert() {
        User u1 = new User();
        u1.setName("tom");
        u1.setPhone("13500001111");
        u1.setPassword("123456");
        u1.setCreateTime(System.currentTimeMillis());
        boolean result = userDao.insert(u1);
        log.info("insert user1 result: {}", result);

        User u2 = new User();
        u2.setName("jerry");
        u2.setPhone("13500002222");
        u2.setPassword("123456");
        u2.setCreateTime(System.currentTimeMillis());
        result = userDao.insert(u2);
        log.info("insert user2 result: {}", result);
    }

    @Test
    public void testSelectById() {
        String name = "tom";
        List<User> list = userDao.selectByName(name);
        if (!list.isEmpty()) {
            long id = list.get(0).getId();
            User user = userDao.selectById(id);
            log.info("select by id, user: {}", user);
        }
    }

    @Test
    public void testSelectByName() {
        String name = "tom";
        List<User> list = userDao.selectByName(name);
        log.info("select by name, user list: {}", list);
    }

    @Test
    public void testUpdatePasswordById() {
        String name = "tom";
        List<User> list = userDao.selectByName(name);
        if (!list.isEmpty()) {
            long id = list.get(0).getId();
            String newPwd = "111111";
            boolean result = userDao.updatePasswordById(id, newPwd);
            log.info("update user result: {}", result);
        }
    }

    @Test
    public void testDeleteById() {
        String name = "tom";
        List<User> list = userDao.selectByName(name);
        if (!list.isEmpty()) {
            long id = list.get(0).getId();
            boolean result = userDao.deleteById(id);
            log.info("delete user result: {}", result);
        }
    }
}
