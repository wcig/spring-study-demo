package com.wcig.app.dao.sample;

import com.wcig.app.model.User;

import java.util.List;

public interface InsertMapper {
    int insert(User user);
    int insertUseGeneratedKeys(User user);
    int batchInsert(List<User> list);
    int batchInsertUseGeneratedKeys(List<User> list);
}
