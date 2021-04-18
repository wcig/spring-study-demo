package com.wcig.app.dao;

import com.wcig.app.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 注解方式使用mybatis (不推荐)
 */
public interface UserMapper {

    @Delete("DELETE FROM user")
    int deleteAll();

    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteById(long id);

    @Insert("INSERT INTO user(`name`,phone,password,create_time) VALUES(#{name},#{phone},#{password},#{createTime})")
    int insert(User user);

    @Insert("INSERT INTO user(`name`,phone,password,create_time) VALUES(#{name},#{phone},#{password},#{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUseGeneratedKeys(User user);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "password", column = "password"),
            @Result(property = "createTime", column = "create_time")
    })
    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectById(long id);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "password", column = "password"),
            @Result(property = "createTime", column = "create_time")
    })
    @Select("SELECT * FROM user WHERE name = #{name}")
    List<User> selectListByName(String name);

    @Update("UPDATE user SET password = #{password} WHERE id = #{id}")
    int updateById(@Param("password") String password, @Param("id") long id);

}
