package com.example.newbe.service.playlistsService;


import com.example.newbe.model.Playlists;
import com.example.newbe.repository.playlistsRepository.IPlaylistsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistsService implements IPlaylistsService {

    @Autowired
    private IPlaylistsRepository playlistsRepository;

    @Override
    public Playlists savePlaylist(Playlists playlist) {
        return playlistsRepository.save(playlist);
    }

    @Override
    public List<Playlists> getAllPlaylists() {
        return playlistsRepository.findAll();
    }

    @Override
    public Optional<Playlists> getPlaylistById(Integer id) {
        return playlistsRepository.findById(id);
    }

    @Override
    public void deletePlaylist(Integer id) {
        playlistsRepository.deleteById(id);
    }

//    @Override
//    public Page<Playlists> findPlaylistsByTitle(Pageable pageable, String name) {
//        return playlistsRepository.findByNamePage(pageable,"%"+name+"%");
//    }

    @Override
    public List<Playlists> findPlayListByName(String name) {
        return playlistsRepository.findByTitleContainingIgnoreCase(name);
    }


}
