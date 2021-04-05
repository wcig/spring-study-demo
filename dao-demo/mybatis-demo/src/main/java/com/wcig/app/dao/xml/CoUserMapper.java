package com.wcig.app.dao.xml;

import com.wcig.app.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// 传统xml方式使用mybatis
public interface CoUserMapper {
    int deleteAll();
    int deleteById(Long id);
    int insert(User user);
    int insertUseGeneratedKeys(User user);
    User selectById(Long id);
    List<User> selectListByName(String name);
    int updateById(@Param("password") String password, @Param("id") Long id);
}
