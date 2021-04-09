package com.wcig.app.dao.sample;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DeleteMapper {
    int deleteByPk(@Param("id") Long id);
    int deleteByMap(@Param("map") Map<String, Object> map);
    int batchDeleteByPk(@Param("list") List<Long> list);
}
