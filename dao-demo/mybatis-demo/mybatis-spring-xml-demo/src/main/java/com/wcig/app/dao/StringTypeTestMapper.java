package com.wcig.app.dao;

import com.wcig.app.model.StringTypeTest;

import java.util.List;

public interface StringTypeTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StringTypeTest record);

    StringTypeTest selectByPrimaryKey(Integer id);

    List<StringTypeTest> selectAll();

    int updateByPrimaryKey(StringTypeTest record);
}