package com.example.Support.dao;

import com.example.Support.entity.Complaint;
import com.example.Support.entity.mapper.ComplaintRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ComplaintDao {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public ComplaintDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Complaint> getComplaints(){
        String sql = "SELECT * FROM complaints";
        return jdbcTemplate.query(sql, new ComplaintRowMapper());
    }

    public Complaint add(Complaint complaint) {
        String sql = "INSERT INTO complaints (description, status, user_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, complaint.getDescription(), complaint.getStatus(), complaint.getUserId());
        return complaint;
    }

    public Complaint update(Complaint complaint){
        String sql = "UPDATE complaints SET description = ?, status = ? WHERE ID = ?";
        jdbcTemplate.update(sql, complaint.getDescription(), complaint.getStatus(), complaint.getId());
        return complaint;
    }

    public void delete(long id){
        String sql = "DELETE From complaints WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
