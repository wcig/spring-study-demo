package com.wcig.app.dao;

import com.wcig.app.model.TimeTypeTest;

import java.util.List;

public interface TimeTypeTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TimeTypeTest record);

    TimeTypeTest selectByPrimaryKey(Integer id);

    List<TimeTypeTest> selectAll();

    int updateByPrimaryKey(TimeTypeTest record);
}