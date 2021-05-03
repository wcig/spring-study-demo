package com.wcig.app.dao;

import com.wcig.app.model.NewTimeTypeTest;

import java.util.List;

public interface NewTimeTypeTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewTimeTypeTest record);

    NewTimeTypeTest selectByPrimaryKey(Integer id);

    List<NewTimeTypeTest> selectAll();

    int updateByPrimaryKey(NewTimeTypeTest record);
}