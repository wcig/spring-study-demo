package com.wcig.app.dao.sample;

import com.wcig.app.model.User;

public interface InsertMapper {
    int insert(User user);
    int insertUseGeneratedKeys(User user);
}
