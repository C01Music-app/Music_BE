package com.example.newbe.service.likeService;

import com.example.newbe.model.Likes;

public interface ILikeService {
    Likes likePlaylist(Integer playlistId, Integer userId);
    void unlikePlaylist(Integer playlistId, Integer userId);
}
