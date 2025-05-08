package com.vena.assignment1.controller;

import com.vena.assignment1.model.User;
import com.vena.assignment1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?>getAllUser(){
        List<User> allUser = userService.getAllUsers();
        return ResponseEntity.ok(allUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getUserById(@PathVariable String id){
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/add")
    public ResponseEntity<?>addUser(@RequestBody User user){
            User newUser = userService.addUser(user);
            return ResponseEntity.status(201).body(newUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return ResponseEntity.status(201).body("User with id " + id + " deleted successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>updateUser(@PathVariable String id, @RequestBody User user){
        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

}