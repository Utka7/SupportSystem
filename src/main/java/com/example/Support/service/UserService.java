package com.example.Support.service;

import com.example.Support.dao.UserDao;
import com.example.Support.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getUsers(){
        return userDao.getUsers();
    }
}
