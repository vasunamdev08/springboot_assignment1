package com.vena.assignment1.controller;

import com.vena.assignment1.model.User;
import com.vena.assignment1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SignupController {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public String signup(@RequestBody User user){
        userService.addUser(user);
        return "User registered successfully";
    }
    @GetMapping("/home")
    public String home(){
        return "Welcome to the home page";
    }
    @GetMapping("/error")
    public String error(){
        return "Error occurred";
    }
}
