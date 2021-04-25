package com.wcig.app.dao;

import com.wcig.app.MybatisSpringXmlApp;
import com.wcig.app.model.Card;
import com.wcig.app.model.Student;
import com.wcig.app.model.StudentCard;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * mybatis一对一映射
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= MybatisSpringXmlApp.class)
public class StudentCardMapperTest {

    @Resource
    private StudentCardMapper studentCardMapper;

    /**
     * mybatis关联映射查询方式
     */
    @Test
    public void testSelectStudentCardByPk() {
        StudentCard sc = studentCardMapper.selectStudentCardByPk(1);
        log.info("result sc: {}", sc);
    }

    /**
     * 代码方式: 多次单独查询拼接
     */
    @Test
    public void testSelectStudentCardByCode() {
        Student s = studentCardMapper.selectStudentByPk(1);
        Card c = studentCardMapper.selectCardByPk(s.getCardId());
        StudentCard sc = new StudentCard();
        sc.setStudentId(s.getStudentId())
                .setName(s.getName())
                .setCard(c);
        log.info("result sc: {}", sc);
    }
}
