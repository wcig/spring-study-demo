package com.wcig.app.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Long id;
    private String name;
    private String phone;
    private String password;
    private Long createTime;
}
