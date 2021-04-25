package com.wcig.app.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * student_course_mapping (学生课程映射表)
 */
@Data
@Accessors(chain = true)
public class StudentCourseMapping {
    // column:student_id, pk:true, maxLength:10, isNull:false, comment:主键id
    private Integer studentId;

    // column:course_id, pk:true, maxLength:10, isNull:false, comment:主键id
    private Integer courseId;
}