package com.wcig.app.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class GradeStudent {
    private Integer gradeId;
    private String name;
    private List<Student> studentList;
}
