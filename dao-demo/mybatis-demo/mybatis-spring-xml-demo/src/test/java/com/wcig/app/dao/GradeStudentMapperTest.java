package com.wcig.app.dao;

import com.wcig.app.MybatisSpringXmlApp;
import com.wcig.app.model.Grade;
import com.wcig.app.model.GradeStudent;
import com.wcig.app.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * mybatis一对多映射
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= MybatisSpringXmlApp.class)
public class GradeStudentMapperTest {

    @Resource
    private GradeStudentMapper gradeStudentMapper;

    /**
     * mybatis关联映射查询方式
     */
    @Test
    public void testSelectGradeStudentByPk() {
        GradeStudent gs = gradeStudentMapper.selectGradeStudentByPk(1);
        log.info("result gs: {}", gs);
    }

    /**
     * 代码方式: 多次单独查询拼接
     */
    @Test
    public void testSelectGradeStudentByCode() {
        Grade g = gradeStudentMapper.selectGradeByPk(1);
        List<Student> list = gradeStudentMapper.selectStudentByGradeId(g.getGradeId());
        GradeStudent gs = new GradeStudent();
        gs.setGradeId(g.getGradeId())
                .setName(g.getName())
                .setStudentList(list);
        log.info("result gs: {}", gs);
    }
}
