package com.wcig.app.dao.sample;

import com.wcig.app.model.User;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    User selectByPk(Long id);
    List<User> selectByName(String name);
    List<User> selectByModel(User user);
    List<User> selectByMap(Map<String, Object> map);
}
