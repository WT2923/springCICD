package com.springboottest.SpringBootTest.controller;

import com.springboottest.SpringBootTest.dto.UserAccessRequest;
import com.springboottest.SpringBootTest.model.UserData;
import com.springboottest.SpringBootTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/register")
    public UserData registerUser(@RequestBody UserAccessRequest registrationRequest) {
        return userService.registerUser(registrationRequest.getUsername(), registrationRequest.getPassword());
    }

    @PostMapping("/login")
    public UserData loginUser(@RequestBody UserAccessRequest loginRequest) {
        return userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());
    }

}
