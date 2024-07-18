package com.example.newbe.repository;

import com.example.newbe.model.Likes;
import com.example.newbe.model.Playlists;
import com.example.newbe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILikeRepository extends JpaRepository<Likes, Integer> {

}