package com.wcig.app.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class CourseStudent {
    private Integer courseId;
    private String name;
    private List<Student> studentList;
}
