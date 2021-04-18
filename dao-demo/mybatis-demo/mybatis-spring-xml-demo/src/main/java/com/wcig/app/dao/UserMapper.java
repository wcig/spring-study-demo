package com.wcig.app.dao;

import com.github.pagehelper.page.PageMethod;
import com.wcig.app.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPk(@Param("id") Long id);
    int deleteByMap(@Param("map") Map<String, Object> map);
    int batchDeleteByPk(@Param("list") List<Long> list);

    int insert(User user);
    int insertUseGeneratedKeys(User user);
    int batchInsert(List<User> list);
    int batchInsertUseGeneratedKeys(List<User> list);

    User selectByPk(Long id);
    List<User> selectByName(String name);
    List<User> selectByModel(User user);
    List<User> selectByMap(Map<String, Object> map);
    List<User> selectByModelWithPage2(@Param("user") User user, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize); // pagehelper config: supportMethodsArguments=true
    default List<User> selectByModelWithPage(User user, int pageNum, int pageSize) {
        PageMethod.startPage(pageNum, pageSize);
        return selectByModel(user);
    }

    int updateByPk(User user);
    int updatePasswordById(@Param("id") Long id, @Param("password") String password);
    int updateByMap(Map<String, Object> map);
    int updateSelectByMap(@Param("record") @NonNull User user, @Param("condition") Map<String, Object> map);
}
