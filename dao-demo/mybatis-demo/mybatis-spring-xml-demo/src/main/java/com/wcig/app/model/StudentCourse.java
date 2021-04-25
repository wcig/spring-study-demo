package com.wcig.app.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class StudentCourse {
    private Integer studentId;
    private String name;
    private Integer cardId;
    private Integer gradeId;
    private List<Course> courseList;
}
