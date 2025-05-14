package com.vena.assignment1.service;

import com.vena.assignment1.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(String id);
    public User addUser(User user);
    public void deleteUser(String id);
    public User updateUser(String id, User user);
    public User getUserByEmail(String email);
}
