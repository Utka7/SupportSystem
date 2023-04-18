package com.example.Support.controllers;

import com.example.Support.entity.Complaint;
import com.example.Support.entity.User;
import com.example.Support.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class MainController {
    @Autowired
    UserService userService;
    @GetMapping
    public List<User> index(){
        System.out.println("Controller");
        return userService.getUsers();
    }


//    // POST запрос для создания жалобы
//    @PostMapping
//    public ResponseEntity<?> createComplaint(@RequestBody ComplaintDto complaintDto) {
//        Complaint complaint = new Complaint();
//        complaint.setDescription(complaintDto.getDescription());
//        complaint.setStatus("new"); // Устанавливаем начальный статус жалобы
//        complaint.setUserId(complaintDto.getUserId());
//        Complaint savedComplaint = complaintService.createComplaint(complaint);
//        return ResponseEntity.ok(savedComplaint);
//    }
}
