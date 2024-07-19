package com.example.newbe.controller;

import com.example.newbe.model.Comment;
import com.example.newbe.model.Songs;
import com.example.newbe.service.ICommentService;
import com.example.newbe.service.ISongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class CommentController {
    @Autowired
    private ICommentService iCommentService;
    @Autowired
    private ISongsService iSongsService;

//    @GetMapping("")
//    public ResponseEntity<?> allComment() {
//        List<Comment> commentList = iCommentService.findAll();
//        return new ResponseEntity<>(commentList, HttpStatus.OK);
//    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdC(@PathVariable Integer id) {
        Comment comment = iCommentService.findById(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity<?> removeC(@PathVariable Integer id) {
        Comment comment = iCommentService.findById(id);
        iCommentService.remove(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }


    @PutMapping("update/{id}")
    public ResponseEntity<?> updateC(@RequestBody Comment comment) {
        iCommentService.update(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
