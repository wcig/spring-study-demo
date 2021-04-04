package com.wcig.app.dao.annotation;

import com.wcig.app.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectById(@Param("id") long id);
}
