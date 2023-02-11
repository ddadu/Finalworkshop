package com.example.newproject.service;

import com.example.newproject.entity.User;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface UserService {
    User save(User user);
    User findById(int id);
    List<User> findAll();
    User update(User user);
    void delete(int id);
}
