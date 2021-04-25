package com.wcig.app.dao;

import com.wcig.app.MybatisSpringXmlApp;
import com.wcig.app.model.CourseStudent;
import com.wcig.app.model.StudentCourse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * mybatis多对多映射
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= MybatisSpringXmlApp.class)
public class StudentCourseMapperTest {

    @Resource
    private StudentCourseMapper studentCourseMapper;

    @Test
    public void testSelectStudentGrade() {
        StudentCourse sc = studentCourseMapper.selectStudentGradeByStudentId(1);
        log.info("result sc: {}", sc);
    }

    @Test
    public void testSelectGradeStudent() {
        CourseStudent cs = studentCourseMapper.selectCourseStudentByCourseId(1);
        log.info("result cs: {}", cs);
    }
}
