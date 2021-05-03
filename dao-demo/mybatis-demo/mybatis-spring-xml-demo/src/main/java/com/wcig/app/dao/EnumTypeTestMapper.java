package com.wcig.app.dao;

import com.wcig.app.model.EnumTypeTest;

import java.util.List;

public interface EnumTypeTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnumTypeTest record);

    EnumTypeTest selectByPrimaryKey(Integer id);

    List<EnumTypeTest> selectAll();

    int updateByPrimaryKey(EnumTypeTest record);
}