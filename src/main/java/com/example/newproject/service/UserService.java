package com.example.newproject.service;

import com.example.newproject.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface UserService {
    User addUser(User user);
    List<User> getUsers();
    User update(int id, User user);
    void delete(int id);
    User getUserById(int id);
}
