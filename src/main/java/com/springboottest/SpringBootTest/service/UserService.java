package com.springboottest.SpringBootTest.service;

import com.springboottest.SpringBootTest.model.UserData;
import com.springboottest.SpringBootTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserData registerUser(String username, String password) {
        UserData newUserData = new UserData();
        newUserData.setUsername(username);
        newUserData.setPassword(passwordEncoder.encode(password));
        return userRepository.save(newUserData);
    }

    public List<UserData> getAllUsers() {
        return userRepository.findAll();
    }

    public UserData loginUser(String username, String password) {
        UserData userData = userRepository.findByUsername(username);
        if (userData != null && passwordEncoder.matches(password, userData.getPassword()))
            return userData;
        return null;
    }
}
