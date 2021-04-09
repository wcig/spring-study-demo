package com.wcig.app.dao.sample;

import com.github.pagehelper.page.PageMethod;
import com.wcig.app.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    User selectByPk(Long id);
    List<User> selectByName(String name);
    List<User> selectByModel(User user);
    List<User> selectByMap(Map<String, Object> map);
    List<User> selectByModelWithPage2(@Param("user") User user, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize); // pagehelper config: supportMethodsArguments=true
    default List<User> selectByModelWithPage(User user, int pageNum, int pageSize) {
        PageMethod.startPage(pageNum, pageSize);
        return selectByModel(user);
    }
}
