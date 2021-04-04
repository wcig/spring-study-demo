package com.wcig.app.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String phone;
    private String password;
    private Long createTime;
}
