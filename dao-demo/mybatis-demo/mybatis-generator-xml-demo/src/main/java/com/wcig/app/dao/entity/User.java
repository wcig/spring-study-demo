package com.wcig.app.dao.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * user (用户信息表)
 */
@Data
@Accessors(chain = true)
public class User {
    // column:id, pk:true, maxLength:10, isNull:false, comment:主键id
    private Integer id;

    // column:name, pk:false, maxLength:60, isNull:false, comment:昵称
    private String name;

    // column:phone, pk:false, maxLength:20, isNull:false, comment:手机号
    private String phone;

    // column:password, pk:false, maxLength:20, isNull:false, comment:密码
    private String password;

    // column:create_time, pk:false, maxLength:20, isNull:false, comment:创建时间
    private Long createTime;
}