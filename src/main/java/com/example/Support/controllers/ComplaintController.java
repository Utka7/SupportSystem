package com.example.Support.controllers;

import com.example.Support.entity.Complaint;
import com.example.Support.entity.User;
import com.example.Support.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    @Autowired
    ComplaintService complaintService;
    @GetMapping
    public List<Complaint> index(){
        return complaintService.getComplaints();
    }

    @PostMapping
    public ResponseEntity<Complaint> create(String description, String status, long userId){
        Complaint complaint = new Complaint(description, status, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(complaintService.addComplaint(complaint));
    }

    @PutMapping("/{complaintId}")
    public ResponseEntity<Complaint> update(long id,String description, String status, long userId){
        Complaint updatedcomplaint = new Complaint(id, description, status, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body( complaintService.updateComplaint(updatedcomplaint));
    }

    @DeleteMapping("/{complaintId}")
    public void delete(long id){
        complaintService.deleteComplaint(id);
    }
}
