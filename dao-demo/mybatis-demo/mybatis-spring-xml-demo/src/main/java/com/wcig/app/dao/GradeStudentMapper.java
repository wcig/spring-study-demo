package com.wcig.app.dao;

import com.wcig.app.model.Grade;
import com.wcig.app.model.GradeStudent;
import com.wcig.app.model.Student;

import java.util.List;

public interface GradeStudentMapper {
    Grade selectGradeByPk(Integer gradeId);
    GradeStudent selectGradeStudentByPk(Integer gradeId);
    List<Student> selectStudentByGradeId(Integer gradeId);
}
