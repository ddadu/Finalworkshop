package com.example.newproject.controller;

import com.example.newproject.entity.User;
import com.example.newproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.addUser(user);
        var location = UriComponentsBuilder.fromPath("/users/" +user.getId()).build().toUri();
        return ResponseEntity.created(location).body(user);
    }

    @PutMapping("/{id}")
    public User update(@RequestBody User user, @PathVariable int id) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <User> delete(@PathVariable int id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
