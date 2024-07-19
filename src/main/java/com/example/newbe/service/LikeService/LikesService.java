package com.example.newbe.service.LikeService;

import com.example.newbe.model.Likes;
import com.example.newbe.repository.ILikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesService implements ILikesService {
    @Autowired
    private ILikesRepository likesRepository;
    @Override
    public Likes likeSong(Likes like) {
        return likesRepository.save(like);
    }

    @Override
    public void unlikeSong(Integer userId, Integer songId) {
        likesRepository.deleteByUserIdAndSongId(userId, songId);
    }

    @Override
    public Likes likePlaylist(Likes like) {
        return likesRepository.save(like);
    }

    @Override
    public void unlikePlaylist(Integer userId, Integer playlistId) {
        likesRepository.deleteByUserIdAndPlaylistId(userId, playlistId);
    }
}
