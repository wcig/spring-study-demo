package com.wcig.app.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcig.app.MybatisGeneratorAnnotationApp;
import com.wcig.app.dao.entity.User;
import com.wcig.app.dao.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.wcig.app.dao.mapper.UserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MybatisGeneratorAnnotationApp.class)
@FixMethodOrder(MethodSorters.JVM) // 设置单元测试类的方法执行顺序
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    public static List<BasicColumn> allColumn() {
        return Arrays.asList(id, name, phone, password, createTime);
    }

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
    public void testCount() {
        SelectStatementProvider selectStatement = select(count())
                .from(user)
                .where(name, isEqualTo("tom"))
                .or(phone, isNull())
                .build()
                .render(RenderingStrategies.MYBATIS3);
        long count = userMapper.count(selectStatement);
        log.info("count user: {}", count);
    }

    @Test
    public void testSelectOne() {
        SelectStatementProvider selectStatement = select(allColumn())
                .from(user)
                .where(name, isEqualTo("tom"))
                .or(phone, isNull())
                .limit(1)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        User user = userMapper.selectOne(selectStatement);
        log.info("select one user: {}", user);
    }

    @Test
    public void testSelectMany() {
        SelectStatementProvider selectStatement = select(allColumn())
                .from(user)
                .where(name, isEqualTo("tom"))
                .or(phone, isNull())
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<User> list = userMapper.selectMany(selectStatement);
        log.info("select list user: {}", list);
    }

    @Test
    public void testSelectManyWithPage() {
        PageHelper.startPage(1, 10);
        SelectStatementProvider selectStatement = select(allColumn())
                .from(user)
                .where(name, isEqualTo("tom"))
                .or(phone, isNull())
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<User> list = userMapper.selectMany(selectStatement);
        log.info("select list user: {}, page info: {}", list, PageInfo.of(list));
    }

    @Test
    public void testSelectByPrimaryKey() {
        SelectStatementProvider selectStatement = select(allColumn())
                .from(user)
                .where(name, isEqualTo("tom"))
                .or(phone, isNull())
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<User> list = userMapper.selectMany(selectStatement);
        if (list.size() > 0) {
            User user = userMapper.selectByPrimaryKey(list.get(0).getId());
            log.info("select by pk user: {}", user);
        }
    }

    @Test
    public void testUpdateByPrimaryKey() {
        SelectStatementProvider selectStatement = select(allColumn())
                .from(user)
                .where(name, isEqualTo("tom"))
                .or(phone, isNull())
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<User> list = userMapper.selectMany(selectStatement);
        if (list.size() > 0) {
            User user = list.get(0).setPhone("13500002222");
            int affected = userMapper.updateByPrimaryKey(user);
            log.info("update user by pk success: {}", affected == 1);
        }
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
        SelectStatementProvider selectStatement = select(allColumn())
                .from(user)
                .where(name, isEqualTo("tom"))
                .or(phone, isNull())
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<User> list = userMapper.selectMany(selectStatement);
        if (list.size() > 0) {
            int id = list.get(0).getId();
            User user = new User().setId(id).setPhone("13500002222");
            int affected = userMapper.updateByPrimaryKeySelective(user);
            log.info("update user by pk with selective success: {}", affected == 1);
        }
    }

    @Test
    public void testUpdate() {
        UpdateStatementProvider provider = update(user)
                .set(phone).equalTo("13500002222")
                .set(password).equalTo("111111")
                .where(name, isEqualTo("tom"))
                .or(phone, isNull())
                .build()
                .render(RenderingStrategies.MYBATIS3);
        int affected = userMapper.update(provider);
        log.info("update user success: {}", affected > 0);
    }

    @Test
    public void testDeleteByPrimaryKey() {
        SelectStatementProvider selectStatement = select(allColumn())
                .from(user)
                .where(name, isEqualTo("tom"))
                .or(phone, isNull())
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<User> list = userMapper.selectMany(selectStatement);
        if (list.size() > 0) {
            int id = list.get(0).getId();
            int affected = userMapper.deleteByPrimaryKey(id);
            log.info("delete user by pk success: {}", affected == 1);
        }
    }

    @Test
    public void testDelete() {
        DeleteStatementProvider provider = deleteFrom(user)
                .where(name, isEqualTo("tom"))
                .or(phone, isNull())
                .build()
                .render(RenderingStrategies.MYBATIS3);
        int affected = userMapper.delete(provider);
        log.info("delete user success: {}", affected > 0);
    }
}
