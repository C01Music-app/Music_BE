package com.example.newbe.controller;

import com.example.newbe.model.User;
import com.example.newbe.service.userService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> showAllUser() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> findUser(@PathVariable Integer id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editUser(@PathVariable Integer id, @RequestBody User user) {
        User existingUser = userService.findById(id);
        if (existingUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        user.setId(id);
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/search/{username}")
    public ResponseEntity<?> searchUserByName(@PathVariable String username) {
        List<User> userList = userService.findAll();
        for (User user : userList) {
            if(user.getUserName().equals(username)){
                return ResponseEntity.badRequest().build();
            }
        }
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }
    @PutMapping("/detail/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody User user) {
        User userDetail = userService.updateUserName(id,user.getUserName(),user.getEmail(), user.getPhone());
        return new ResponseEntity<>(userDetail, HttpStatus.OK);
    }
    @PutMapping("/password/{id}")
    public ResponseEntity<?> updateUserPassword(@PathVariable Integer id, @RequestBody User user) {
        User user1 = userService.updatePassword(id, user.getPassword());
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }
}
