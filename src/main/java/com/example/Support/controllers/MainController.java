package com.example.Support.controllers;

import com.example.Support.entity.Complaint;
import com.example.Support.entity.User;
import com.example.Support.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity<User> create(String name, String password, String email, String role){
        User user = new User(name, password, email, role);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(long id,String name, String password, String email, String role){
        User updatedUser = new User(id, name, password, email, role);
        return ResponseEntity.status(HttpStatus.CREATED).body( userService.updateUser(updatedUser));
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(long id){
        userService.deleteUser(id);
    }
}
