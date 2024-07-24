package com.example.newbe.controller;

import com.example.newbe.dto.ChangePassword;
import com.example.newbe.dto.ResponseDto;
import com.example.newbe.model.User;
import com.example.newbe.service.userService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

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
    @PutMapping("/password")
    public ResponseEntity<?> updateUserPassword(@RequestBody ChangePassword changePassword) {
        User user = userService.findByUsername(changePassword.getUserName());

        if(!passwordEncoder.matches(changePassword.getOldPassword(),user.getPassword())){
            return new ResponseEntity<>(new ResponseDto("Wrong Password!!","ERROR"),HttpStatus.OK);
        }
        user.setPassword(changePassword.getNewPassword());
        userService.save(user);
        return ResponseEntity.ok(new ResponseDto("Updated!!","OK"));
    }
}
