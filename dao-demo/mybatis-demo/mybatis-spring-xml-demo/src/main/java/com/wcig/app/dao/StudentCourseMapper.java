package com.wcig.app.dao;

import com.wcig.app.model.Course;
import com.wcig.app.model.CourseStudent;
import com.wcig.app.model.Student;
import com.wcig.app.model.StudentCourse;

public interface StudentCourseMapper {
    Student selectStudentByPk(Integer studentId);
    Course selectCourseByPk(Integer courseId);
    StudentCourse selectStudentGradeByStudentId(Integer studentId);
    CourseStudent selectCourseStudentByCourseId(Integer courseId);
}
