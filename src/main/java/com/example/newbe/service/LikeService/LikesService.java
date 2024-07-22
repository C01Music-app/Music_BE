package com.example.newbe.service.LikeService;

import com.example.newbe.model.Likes;
import com.example.newbe.model.Songs;
import com.example.newbe.model.Playlists;
import com.example.newbe.model.User;
import com.example.newbe.repository.ILikesRepository;
import com.example.newbe.repository.ISongsRepository;
import com.example.newbe.repository.IUserRepository;
import com.example.newbe.repository.playlistsRepository.IPlaylistsRepository;
import com.example.newbe.service.LikeService.ILikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesService implements ILikesService {

    @Autowired
    private ILikesRepository likeRepository;

    @Autowired
    private ISongsRepository songsRepository;

    @Autowired
    private IPlaylistsRepository playlistsRepository;

    @Autowired
    private IUserRepository userRepository;

    public void likeItem(String itemType, Integer itemId, Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Likes like = new Likes();
        like.setUser(user);

        if ("song".equalsIgnoreCase(itemType)) {
            Songs song = songsRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Song not found"));
            like.setSong(song);
        } else if ("playlist".equalsIgnoreCase(itemType)) {
            Playlists playlist = playlistsRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Playlist not found"));
            like.setPlaylist(playlist);
        }

        likeRepository.save(like);
    }

    public void unlikeItem(String itemType, Integer itemId, Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        if ("song".equalsIgnoreCase(itemType)) {
            Songs song = songsRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Song not found"));
            likeRepository.findByUserAndSong(user, song).ifPresent(likeRepository::delete);
        } else if ("playlist".equalsIgnoreCase(itemType)) {
            Playlists playlist = playlistsRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Playlist not found"));
            likeRepository.findByUserAndPlaylist(user, playlist).ifPresent(likeRepository::delete);
        }
    }

    public boolean checkIfLiked(Integer userId, Integer itemId, String itemType) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        if ("song".equalsIgnoreCase(itemType)) {
            Songs song = songsRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Song not found"));
            return likeRepository.findByUserAndSong(user, song).isPresent();
        } else if ("playlist".equalsIgnoreCase(itemType)) {
            Playlists playlist = playlistsRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Playlist not found"));
            return likeRepository.findByUserAndPlaylist(user, playlist).isPresent();
        }

        return false;
    }
}
