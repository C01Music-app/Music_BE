package com.example.newbe.repository;

import com.example.newbe.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepository extends JpaRepository<Comment,Integer> {


    List<Comment> findAllBySongId(Integer id);

}
