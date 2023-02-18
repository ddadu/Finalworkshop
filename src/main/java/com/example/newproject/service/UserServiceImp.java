package com.example.newproject.service;

import com.example.newproject.entity.User;
import com.example.newproject.exception.NotFoundException;
import com.example.newproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{
    private final UserRepository userRepository;
    @Override
    public User addUser(User user) {
        user.setId(user.getId());
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User update(int id,User user) {
        var foundUser = getUserById(id);
        foundUser.setUsername(user.getUsername());
        foundUser.setPassword(user.getPassword());
        userRepository.save(foundUser);
        return foundUser;
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("User not found"));
    }
}
