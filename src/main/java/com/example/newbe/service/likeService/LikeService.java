package com.example.newbe.service.likeService;

import com.example.newbe.model.Likes;
import com.example.newbe.model.Playlists;
import com.example.newbe.model.User;
import com.example.newbe.repository.ILikeRepository;
import com.example.newbe.repository.IUserRepository;
import com.example.newbe.repository.playlistsRepository.IPlaylistsRepository;
import com.example.newbe.service.playlistsService.IPlaylistsService;
import com.example.newbe.service.userService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService implements ILikeService {

    @Autowired
    private ILikeRepository likesRepository;

    @Autowired
    private IPlaylistsService playlistsService; // Assume PlaylistService is defined similarly

    @Autowired
    private IUserService userService; // Assume UserService is defined similarly


    @Override
    public Likes likePlaylist(Integer playlistId, Integer userId) {
        return null;
    }

    @Override
    public void unlikePlaylist(Integer playlistId, Integer userId) {

    }

}
