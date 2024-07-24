package com.example.newbe.service;

import com.example.newbe.model.Playlists;
import com.example.newbe.model.Songs;
import com.example.newbe.repository.ICommentRepository;
import com.example.newbe.repository.ISongsRepository;
import com.example.newbe.repository.playlistsRepository.IPlaylistsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SongsService implements ISongsService {

    @Autowired
    private ISongsRepository iSongsRepository;

    @Autowired
    private IPlaylistsRepository iPlaylistsRepository ;  // Add this line

    @Autowired
    private ICommentRepository iCommentRepository;

    @Override
    public Page<Songs> getAllPage(Pageable pageable, String name) {
        return iSongsRepository.findAll(pageable);
    }

    @Override
    public void save(Songs songs) {
        iSongsRepository.save(songs);
    }

    @Override
    public Songs findById(Integer id) {
        return iSongsRepository.findById(id).get();
    }

    @Override
    public void removeSongs(Songs songs) {
        iSongsRepository.delete(songs);
    }

    @Override
    public void detail(Songs songs) {
        iSongsRepository.findById(songs.getId());
    }

    @Override
    public List<Songs> findSongsByName(String name) {
        return iSongsRepository.findByTitleContainingIgnoreCase(name);
    }

    @Override
    public List<Songs> findAll() {
        return iSongsRepository.findAllSongs();
    }


    @Override
    public void updateS(Songs songs) {
        iSongsRepository.save(songs);
    }


    @Transactional
    @Override
    public void removePlaylistFromSong(Integer songId, Integer playlistId) {
        Optional<Songs> songOptional = iSongsRepository.findById(songId);
        Optional<Playlists> playlistOptional = iPlaylistsRepository.findById(playlistId);

        if (songOptional.isPresent() && playlistOptional.isPresent()) {
            Songs song = songOptional.get();
            Playlists playlist = playlistOptional.get();
            song.getPlaylists().remove(playlist);
            iSongsRepository.save(song);
        } else {
            throw new RuntimeException("Song or Playlist not found");
        }
    }

    public void addPlaylistToSong(Integer songId, Integer playlistId) throws Exception {
        Songs song = iSongsRepository.findById(songId)
                .orElseThrow(() -> new Exception("Song not found"));

        Playlists playlist = iPlaylistsRepository.findById(playlistId)
                .orElseThrow(() -> new Exception("Playlist not found"));

        song.getPlaylists().add(playlist);

        iSongsRepository.save(song);
    }

    @Override
    public void deleteComment(Integer id, Integer commentId) {
        iCommentRepository.deleteById(commentId);
    }

}
