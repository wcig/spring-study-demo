package com.wcig.app.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * student (学生信息表)
 */
@Data
@Accessors(chain = true)
public class Student {
    // column:student_id, pk:true, maxLength:10, isNull:false, comment:主键id
    private Integer studentId;

    // column:name, pk:false, maxLength:60, isNull:false, comment:姓名
    private String name;

    // column:card_id, pk:false, maxLength:10, isNull:false, comment:身份证id
    private Integer cardId;

    // column:grade_id, pk:false, maxLength:10, isNull:false, comment:班级id
    private Integer gradeId;
}