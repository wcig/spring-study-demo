package com.wcig.app.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String phone;
    private String password;
    private Long createTime;

    public User() {
    }

    public User(String name, String phone, String password, Long createTime) {
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.createTime = createTime;
    }

    public User(Long id, String name, String phone, String password, Long createTime) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.createTime = createTime;
    }

    public User copy() {
        return new User(this.id, this.name, this.phone, this.password, this.createTime);
    }
}
