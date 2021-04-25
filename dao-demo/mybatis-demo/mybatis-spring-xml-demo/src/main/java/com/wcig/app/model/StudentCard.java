package com.wcig.app.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class StudentCard {
    private Integer studentId;
    private String name;
    private Card card;
}
