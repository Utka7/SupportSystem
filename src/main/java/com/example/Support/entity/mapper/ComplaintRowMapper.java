package com.example.Support.entity.mapper;

import com.example.Support.entity.Complaint;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComplaintRowMapper implements RowMapper<Complaint> {
    @Override
    public Complaint mapRow(ResultSet rs, int rowNum) throws SQLException {
        Complaint complaint = new Complaint();
        complaint.setId(rs.getLong("id"));
        complaint.setDescription(rs.getString("description"));
        complaint.setStatus(rs.getString("status"));
        complaint.setUserId(rs.getLong("user_id"));
        return complaint;
    }
}
