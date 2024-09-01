package com.ali.Movie_Map.controller;

import com.ali.Movie_Map.model.User;
import com.ali.Movie_Map.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @PostMapping("/register")
    public User register(@RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
