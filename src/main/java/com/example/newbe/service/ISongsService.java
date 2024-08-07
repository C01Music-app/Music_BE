package com.example.newbe.service;

import com.example.newbe.model.Songs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISongsService {

    Page<Songs> getAllPage(Pageable pageable, String name);

    void save(Songs songs);

    Songs findById(Integer id);

    void removeSongs(Songs songs);


    void detail(Songs songs);

    List<Songs> findSongsByName(String name);

    List<Songs> findAll();


    void updateS(Songs songs);

    void removePlaylistFromSong(Integer songId, Integer playlistId);

    void addPlaylistToSong(Integer songId, Integer playlistId) throws Exception;

    void deleteComment(Integer id, Integer commentId);

}
