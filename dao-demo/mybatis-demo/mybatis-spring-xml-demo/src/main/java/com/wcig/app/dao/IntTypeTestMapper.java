package com.wcig.app.dao;

import com.wcig.app.model.IntTypeTest;

import java.util.List;

public interface IntTypeTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IntTypeTest record);

    IntTypeTest selectByPrimaryKey(Integer id);

    List<IntTypeTest> selectAll();

    int updateByPrimaryKey(IntTypeTest record);
}