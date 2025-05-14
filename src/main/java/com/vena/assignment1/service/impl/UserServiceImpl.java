package com.vena.assignment1.service.impl;

import com.vena.assignment1.dao.UserRepository;
import com.vena.assignment1.model.User;
import com.vena.assignment1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        if(users.isEmpty()) {
            throw new RuntimeException("No users found");
        }
        return users;
    }

    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User addUser(User user) {
        if(user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
            throw new RuntimeException("User details are incomplete");
        }
        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists with email: " + user.getEmail());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        userRepository.delete(user);
    }

    public User updateUser(String id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(existingUser);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(()->
                    new RuntimeException("User not found with email: " + email));
    }

}
