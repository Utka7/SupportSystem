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

    public User addUser(User user){
       return userDao.addUser(user);
    }

    public User updateUser(User user){
        return userDao.update(user);
    }

    public void deleteUser(long id){
        userDao.delete(id);
    }
}
