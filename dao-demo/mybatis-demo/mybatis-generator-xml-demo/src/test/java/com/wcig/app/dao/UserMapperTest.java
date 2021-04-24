package com.wcig.app.dao;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.wcig.app.MybatisGeneratorXmlDemo;
import com.wcig.app.dao.entity.User;
import com.wcig.app.dao.entity.UserExample;
import com.wcig.app.dao.mapper.UserMapper;
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
@ContextConfiguration(classes= MybatisGeneratorXmlDemo.class)
@FixMethodOrder(MethodSorters.JVM) // 设置单元测试类的方法执行顺序
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        User user = new User().setName("tom").setPhone("13500001111").setPassword("123456").setCreateTime(System.currentTimeMillis());
        int affected = userMapper.insert(user);
        log.info("insert user success: {}, user: {}", affected == 1, user);
    }

    @Test
    public void testInsertSelective() {
        User user = new User().setName("tom").setPhone("13500002222").setPassword("111111");
        int affected = userMapper.insertSelective(user);
        log.info("insert user success: {}, user: {}", affected == 1, user);
    }

    @Test
    public void testCountByExample() {
        // count all
        long num = userMapper.countByExample(new UserExample());
        log.info("total user count: {}", num);

        // count with condition
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo("tom").andPhoneLike("13500001111");
        long num2 = userMapper.countByExample(userExample);
        log.info("condition user count: {}", num2);
    }

    @Test
    public void testSelectByExample() {
        UserExample userExample = new UserExample();
        userExample.setOrderByClause("id desc");
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo("tom").andPhoneLike("13500001111");
        List<User> list = userMapper.selectByExample(userExample);
        log.info("select by example: {}", list);
    }

    @Test
    public void testSelectByExampleWithPage() {
        UserExample userExample = new UserExample();
        userExample.setOrderByClause("id desc");
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo("tom").andPhoneLike("13500001111");
        PageMethod.startPage(1, 10);
        List<User> list = userMapper.selectByExample(userExample);
        log.info("select by example total: {}, list: {}", PageInfo.of(list).getTotal(), list);
    }

    @Test
    public void testSelectByPrimaryKey() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo("tom").andPhoneLike("13500001111");
        List<User> list = userMapper.selectByExample(userExample);
        if (list.size() > 0) {
            User user = userMapper.selectByPrimaryKey(list.get(0).getId());
            log.info("select by pk user: {}", user);
        }
    }

    @Test
    public void testUpdateByPrimaryKey() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo("tom").andPhoneLike("13500001111");
        List<User> list = userMapper.selectByExample(userExample);
        if (list.size() > 0) {
            User user = list.get(0);
            user.setPhone("13500002222");
            int affected = userMapper.updateByPrimaryKey(user);
            log.info("update user by pk success: {}", affected == 1);
        }
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo("tom").andPhoneLike("13500001111");
        List<User> list = userMapper.selectByExample(userExample);
        if (list.size() > 0) {
            int id = list.get(0).getId();
            User user = new User().setId(id).setPhone("13500002222");
            int affected = userMapper.updateByPrimaryKeySelective(user);
            log.info("update user by pk with selective success: {}", affected == 1);
        }
    }

    /**
     * 比较不实用
     */
    @Test
    public void testUpdateByExample() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo("tom").andPhoneLike("13500001111");
        List<User> list = userMapper.selectByExample(userExample);
        if (list.size() > 0) {
            User user = list.get(0);
            criteria.andIdEqualTo(user.getId());
            User record = new User().setId(user.getId()).setName("tom").setPhone("13500002222").setPassword("111111").setCreateTime(user.getCreateTime());
            int affected = userMapper.updateByExample(record, userExample);
            log.info("update user by example success: {}", affected == 1);
        }
    }

    @Test
    public void testUpdateByExampleSelective() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo("tom").andPhoneLike("13500001111");
        User record = new User().setPhone("13500002222");
        int affected = userMapper.updateByExampleSelective(record, userExample);
        log.info("update user by example selective success: {}", affected == 1);
    }

    @Test
    public void testDeleteByPrimaryKey() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo("tom");
        List<User> list = userMapper.selectByExample(userExample);
        if (list.size() > 0) {
            int id = list.get(0).getId();
            int affected = userMapper.deleteByPrimaryKey(id);
            log.info("delete user by example success: {}", affected == 1);
        }
    }

    @Test
    public void testDeleteByPrimaryKeySelective() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo("tom").andPhoneLike("13500002222");
        int affected = userMapper.deleteByExample(userExample);
        log.info("delete user by example selective success: {}", affected > 0);
    }
}
