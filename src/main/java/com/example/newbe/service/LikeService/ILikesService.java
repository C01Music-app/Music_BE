package com.example.newbe.service.LikeService;

import com.example.newbe.model.Likes;
import org.springframework.stereotype.Service;

@Service
public interface ILikesService  {
    Likes likeSong(Likes like);

    void unlikeSong(Integer userId, Integer songId);

    Likes likePlaylist(Likes like);

    void unlikePlaylist(Integer userId, Integer playlistId);
}
