package com.wcig.app.dao.sample;

import com.wcig.app.MybatisDemoApp;
import com.wcig.app.dao.xml.CoUserMapper;
import com.wcig.app.model.User;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= MybatisDemoApp.class)
@FixMethodOrder(MethodSorters.JVM) // 设置单元测试类的方法执行顺序
public class UpdateMapperTest {

    @Resource
    CoUserMapper userMapper;

    @Resource
    private UpdateMapper mapper;

    @Test
    public void testUpdateByPk() {
        List<User> userList = userMapper.selectListByName("tom");
        if (!userList.isEmpty()) {
            long id = userList.get(0).getId();
            User user = new User();
            user.setId(id);
            user.setPassword("111111");
            int num  = mapper.updateByPk(user);
            log.info("updateByPk affected num: {}", num);
        }
    }

    @Test
    public void testUpdateNameById() {
        List<User> userList = userMapper.selectListByName("tom");
        if (!userList.isEmpty()) {
            long id = userList.get(0).getId();
            String newPwd = "111111";
            int num  = mapper.updatePasswordById(id, newPwd);
            log.info("updatePasswordById affected num: {}", num);
        }
    }

    @Test
    public void TestUpdateByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "tom");
        map.put("password", "111111");
        int num = mapper.updateByMap(map);
        log.info("updateByMap affected num: {}", num);
    }

    @Test
    public void TestUpdateSelectByMap() {
        {
            User user = new User();
            user.setName("tom");
            user.setPassword("111111");
            int num = mapper.updateSelectByMap(user, null);
            log.info("updateSelectByMap affected num: {}", num);
        }
        {
            User user = new User();
            user.setPassword("123456");
            Map<String, Object> map = new HashMap<>();
            map.put("name", "tom");
            map.put("password", "111111");
            int num = mapper.updateSelectByMap(user, map);
            log.info("updateSelectByMap affected num: {}", num);
        }
    }
}
