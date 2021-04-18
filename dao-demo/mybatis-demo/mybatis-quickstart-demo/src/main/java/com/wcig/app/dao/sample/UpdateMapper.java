package com.wcig.app.dao.sample;

import com.wcig.app.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.NonNull;

import java.util.Map;

public interface UpdateMapper {
    int updateByPk(User user);
    int updatePasswordById(@Param("id") Long id, @Param("password") String password);
    int updateByMap(Map<String, Object> map);
    int updateSelectByMap(@Param("record") @NonNull User user, @Param("condition") Map<String, Object> map);
}
