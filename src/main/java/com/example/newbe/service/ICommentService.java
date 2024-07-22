package com.example.newbe.service;

import com.example.newbe.model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();


    void save(Comment comment);

    Comment findById(Integer id);

    void remove(Comment comment);

    void update(Comment comment);

    List<Comment> findAllBySongId(Integer id);

}
