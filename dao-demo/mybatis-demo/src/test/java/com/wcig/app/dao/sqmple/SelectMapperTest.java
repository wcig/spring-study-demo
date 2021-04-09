package com.wcig.app.dao.sqmple;

import com.wcig.app.MybatisDemoApp;
import com.wcig.app.dao.sample.SelectMapper;
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
@FixMethodOrder(MethodSorters.JVM)
public class SelectMapperTest {

    @Resource
    private SelectMapper mapper;

    @Test
    public void testSelectByPk() {
        User user = mapper.selectByPk(13L);
        log.info("selectByPk result user: {}", user);
    }
}
