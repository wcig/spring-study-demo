package com.wcig.app.dao;

import com.wcig.app.model.User;

public interface UserMapper {
    User selectById(long id);
}
