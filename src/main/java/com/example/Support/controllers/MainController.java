package com.example.Support.controllers;

import com.example.Support.entity.Complaint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String index(){
        return "Hello";
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
