package com.wcig.app.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * grade (班级信息表)
 */
@Data
@Accessors(chain = true)
public class Grade {
    // column:grade_id, pk:true, maxLength:10, isNull:false, comment:主键id
    private Integer gradeId;

    // column:name, pk:false, maxLength:60, isNull:false, comment:班级名称
    private String name;
}
