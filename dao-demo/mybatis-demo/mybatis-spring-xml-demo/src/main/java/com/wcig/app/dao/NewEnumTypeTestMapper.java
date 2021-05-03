package com.wcig.app.dao;

import com.wcig.app.model.NewEnumTypeTest;

import java.util.List;

public interface NewEnumTypeTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewEnumTypeTest record);

    NewEnumTypeTest selectByPrimaryKey(Integer id);

    List<NewEnumTypeTest> selectAll();

    int updateByPrimaryKey(NewEnumTypeTest record);
}