package com.example.Support.dao;

import com.example.Support.entity.User;
import com.example.Support.entity.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<User> getUsers(){
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    public User addUser(User user) {
        String sql = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), user.getRole());
        return user;
    }

    public User update(User user){
        String sql = "UPDATE users SET name = ?, email = ?, password = ?, role = ? WHERE ID = ?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), user.getRole(), user.getId());
        return user;
    }

    public void delete(long id){
        String sql = "DELETE From users WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}
