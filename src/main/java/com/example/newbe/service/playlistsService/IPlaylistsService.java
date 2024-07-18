package com.example.newbe.service.playlistsService;

import com.example.newbe.model.Likes;
import com.example.newbe.model.Playlists;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IPlaylistsService {

    List<Playlists> getAllPlaylists();

    Playlists savePlaylist(Playlists playlist);

    Playlists getPlaylistById(Integer id);

    void deletePlaylist(Integer id);

    List<Playlists> findPlayListByName(String name);

    Optional<Playlists> findById(Integer playlistId);

    Optional<Playlists> getPlaylistById1(Integer playlistId);

    Likes likePlaylist(Integer id, Likes like);

}
