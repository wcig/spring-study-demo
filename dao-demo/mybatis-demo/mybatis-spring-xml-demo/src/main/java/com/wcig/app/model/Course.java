package com.wcig.app.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Course {
    // column:course_id, pk:true, maxLength:10, isNull:false, comment:主键id
    private Integer courseId;

    // column:name, pk:false, maxLength:60, isNull:false, comment:课程名称
    private String name;
}
