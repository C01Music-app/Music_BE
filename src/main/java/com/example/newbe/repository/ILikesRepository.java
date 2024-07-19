package com.example.newbe.repository;

import com.example.newbe.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikesRepository extends JpaRepository<Likes, Integer> {
    void deleteByUserIdAndSongId(Integer userId, Integer songId);
    void deleteByUserIdAndPlaylistId(Integer userId, Integer playlistId);
}
