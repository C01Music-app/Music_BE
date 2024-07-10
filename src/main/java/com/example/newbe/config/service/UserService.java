package com.example.newbe.config.service;

import com.example.newbe.config.UserPrinciple;
import com.example.newbe.model.User;
import com.example.newbe.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService  {
    @Autowired
    private IUserRepository userRepository;

    public User findByUsername(String name) {
        return userRepository.findByUserName(name);
    }

    public UserDetails loadUserByUsername(String username) {
        return UserPrinciple.build(userRepository.findByUserName(username));
    }
}
