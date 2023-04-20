package com.example.Support.service;

import com.example.Support.dao.ComplaintDao;
import com.example.Support.dao.UserDao;
import com.example.Support.entity.Complaint;
import com.example.Support.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComplaintService {

    @Autowired
    private ComplaintDao complaintDao;

    public List<Complaint> getComplaints(){
        return complaintDao.getComplaints();
    }

    public Complaint addComplaint(Complaint complaint){
        return complaintDao.add(complaint);
    }

    public Complaint updateComplaint(Complaint complaint){
        return complaintDao.update(complaint);
    }

    public void deleteComplaint(long id){
        complaintDao.delete(id);
    }
}
