package com.example.hepatohub.controller;

import com.example.hepatohub.model.User;
import com.example.hepatohub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<com.example.hepatohub.model.User> list() {
        return userService.listAllUsers();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody com.example.hepatohub.model.User user) {
        User savedUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

}