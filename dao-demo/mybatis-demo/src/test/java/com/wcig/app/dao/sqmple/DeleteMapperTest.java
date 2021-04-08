package com.wcig.app.dao.sqmple;

import com.wcig.app.MybatisDemoApp;
import com.wcig.app.dao.sample.DeleteMapper;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= MybatisDemoApp.class)
@FixMethodOrder(MethodSorters.JVM)
public class DeleteMapperTest {

    @Resource
    private CoUserMapper userMapper;
    @Resource
    private DeleteMapper mapper;

    @Test
    public void testDeleteByPk() {
        List<User> userList = userMapper.selectListByName("tom");
        if (!userList.isEmpty()) {
            long id = userList.get(0).getId();
            int num  = mapper.deleteByPk(id);
            log.info("deleteByPk affected num: {}", num);
        }
    }

    @Test
    public void testDeleteByMap() {
        Map<String, Object> map = new HashMap<>();
        int num = mapper.deleteByMap(map);
        log.info("deleteByMap empty map affected num: {}", num);

        map.put("name", "tom");
        map.put("password", "111111");
        num = mapper.deleteByMap(map);
        log.info("deleteByMap not empty map affected num: {}", num); // TODO
    }

    @Test
    public void testBatchDeleteByPk() {
        List<Long> list = new ArrayList<>();
        int num = mapper.batchDeleteByPk(list);
        log.info("batchDeleteByPk empty list affected num: {}", num);

        list.add(9L);
        list.add(10L);
        num = mapper.batchDeleteByPk(list);
        log.info("batchDeleteByPk not empty list affected num: {}", num);
    }
}
