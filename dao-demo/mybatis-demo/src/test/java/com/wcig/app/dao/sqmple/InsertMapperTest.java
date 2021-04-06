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
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= MybatisDemoApp.class)
@FixMethodOrder(MethodSorters.JVM) // 设置单元测试类的方法执行顺序
public class InsertMapperTest {

    @Resource
    private InsertMapper mapper;

    @Test
    public void testInsert() {
        User user = new User("tom", "13500001111", "123456", System.currentTimeMillis());
        boolean result = mapper.insert(user) > 0;
        log.info("insert user result: {}", result);
    }

    @Test
    public void testInsertUseGeneratedKeys() {
        User user = new User("jerry", "13500002222", "123456", System.currentTimeMillis());
        boolean result = mapper.insertUseGeneratedKeys(user) > 0;
        log.info("insertUseGeneratedKeys result:{}, user id: {}", result, user.getId());
    }

    @Test
    public void testBatchInsert() {
        List<User> list = new ArrayList<>();
        list.add(new User("tom", "13500001111", "123456", System.currentTimeMillis()));
        list.add(new User("jerry", "13500002222", "123456", System.currentTimeMillis()));
        int num = mapper.batchInsertUseGeneratedKeys(list);
        log.info("batchInsert success num: {}", num);
        if (num == list.size()) {
            log.info("batchInsert success user id list: {}, {}", list.get(0).getId(), list.get(1).getId());
        }
    }
}
