package com.example.Support.dao;

import com.example.Support.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {
    JdbcTemplate jdbcTemplate;

    public List<User> getUsers(){
        String sql = "SELECT * FROM users";
//        List<User> users = jdbcTemplate.query(sql, new user.RowMapper);
    }

}
