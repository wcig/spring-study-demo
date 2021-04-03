package com.wcig.app.dao;

import com.wcig.app.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public boolean insert(User user) {
        String sql = "INSERT INTO user(`name`,phone,password,create_time) VALUES(?,?,?,?)";
        return jdbcTemplate.update(sql, user.getName(), user.getPhone(), user.getPassword(), user.getCreateTime()) > 0;
    }

    public User selectById(long id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        RowMapper<User> mapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.queryForObject(sql, mapper, id);
    }

    public List<User> selectByName(String name) {
        String sql = "SELECT * FROM user WHERE name = ?";
        RowMapper<User> mapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.query(sql, mapper, name);
    }

    public boolean updatePasswordById(long id, String password) {
        String sql = "UPDATE user SET password = ? WHERE id = ?";
        RowMapper<User> mapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.update(sql, password, id) > 0;
    }

    public boolean deleteById(long id) {
        String sql = "DELETE FROM user WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }
}
