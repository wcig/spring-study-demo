package com.wcig.app.dao.sample;

import com.wcig.app.model.User;
import org.apache.ibatis.annotations.Param;

public interface UpdateMapper {
    int updateByPk(User user);
    int updatePasswordById(@Param("id") Long id, @Param("password") String password);
}
