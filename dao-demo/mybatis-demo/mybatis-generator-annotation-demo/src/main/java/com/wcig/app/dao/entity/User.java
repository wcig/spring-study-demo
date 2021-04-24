package com.wcig.app.dao.entity;

import javax.annotation.Generated;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * user (用户信息表)
 */
@Data
@Accessors(chain = true)
public class User {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    // column:id, pk:true, maxLength:10, isNull:false, comment:主键id
    private Integer id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    // column:name, pk:false, maxLength:60, isNull:false, comment:昵称
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    // column:phone, pk:false, maxLength:20, isNull:false, comment:手机号
    private String phone;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    // column:password, pk:false, maxLength:20, isNull:false, comment:密码
    private String password;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    // column:create_time, pk:false, maxLength:20, isNull:false, comment:创建时间
    private Long createTime;
}