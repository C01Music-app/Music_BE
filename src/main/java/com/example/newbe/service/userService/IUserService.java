package com.example.newbe.service.userService;

import com.example.newbe.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(Integer id);
    void save(User user);
    void deleteById(Integer id);
    User findByUsername(String username);
}
