package com.example.newbe.repository;

import com.example.newbe.model.Likes;
import com.example.newbe.model.Playlists;
import com.example.newbe.model.Songs;
import com.example.newbe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILikesRepository extends JpaRepository<Likes, Integer> {

    Optional<Likes> findByUserAndSong(User user, Songs song);

    Optional<Likes> findByUserAndPlaylist(User user, Playlists playlist);
}
