package com.wcig.app.dao.sample;

import com.wcig.app.MybatisDemoApp;
import com.wcig.app.dao.sample.SelectMapper;
import com.wcig.app.dao.xml.CoUserMapper;
import com.wcig.app.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= MybatisDemoApp.class)
@FixMethodOrder(MethodSorters.JVM)
public class SelectMapperTest {

    @Resource
    CoUserMapper userMapper;
    @Resource
    private SelectMapper mapper;

    @Before
    public void initData() {
        User user = new User("tom", "13500001111", "123456", System.currentTimeMillis());
        for(int i=0; i<100; i++) {
            User u = user.copy();
            u.setCreateTime(System.currentTimeMillis());
            int num = userMapper.insert(u);
            assertEquals(1, num);
        }
    }

    @After
    public void releaseData() {
        userMapper.deleteAll();
    }

    @Test
    public void testSelectByPk() {
        List<User> list = userMapper.selectListByName("tom");
        assertTrue(list.size() > 0);

        long id = list.get(0).getId();
        User user = mapper.selectByPk(id);
        log.info("selectByPk result user: {}", user);
        assertNotNull(user);
    }

    @Test
    public void testSelectByName() {
        List<User> list = mapper.selectByName("tom");
        log.info("selectByName result user list: {}", list);
        assertTrue(list.size() > 0);
    }

    @Test
    public void testSelectByModel() {
        User user = new User();
        user.setName("tom");
        user.setPassword("123456");
        List<User> list = mapper.selectByModel(user);
        log.info("selectByModel result user list: {}", list);
        assertTrue(list.size() > 0);
    }

    @Test
    public void testSelectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "tom");
        map.put("password", "123456");
        List<User> list = mapper.selectByMap(map);
        log.info("selectByMap result user list: {}", list);
        assertTrue(list.size() > 0);
    }

    @Test
    public void testSelectByModelWithPage() {
        User user = new User();
        user.setName("tom");
        List<User> list = mapper.selectByModelWithPage(user, 3, 10);
        log.info("selectByModelWithPage result user list: {}", list);
        assertTrue(list.size() > 0);
    }

    @Test
    public void testSelectByModelWithPage2() {
        User user = new User();
        user.setName("tom");
        List<User> list = mapper.selectByModelWithPage2(user, 3, 10);
        log.info("selectByModelWithPage2 result user list: {}", list);
        assertTrue(list.size() > 0);
    }
}
