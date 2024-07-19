package com.example.newbe.service;

import com.example.newbe.model.Comment;
import com.example.newbe.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepository iCommentRepository;

    @Override
    public List<Comment> findAll() {
        return iCommentRepository.findAll();
    }

    @Override
    public void save(Comment comment) {
        iCommentRepository.save(comment);
    }

    @Override
    public Comment findById(Integer id) {
        return iCommentRepository.findById(id).get();
    }

    @Override
    public void remove(Comment comment) {
        iCommentRepository.delete(comment);
    }

    @Override
    public void update(Comment comment) {
        iCommentRepository.save(comment);
    }

    @Override
    public List<Comment> findAllBySongId(Integer id) {
        return iCommentRepository.findAllBySongId(id);
    }


}
