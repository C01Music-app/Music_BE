package com.example.newbe.controller;

import com.example.newbe.model.Likes;
import com.example.newbe.service.likeService.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private ILikeService likeService;

    @PostMapping("/{playlistId}/like")
    public ResponseEntity<Likes> likePlaylist(@PathVariable Integer playlistId, @RequestHeader("userId") Integer userId) {
        Likes like = likeService.likePlaylist(playlistId, userId);
        return ResponseEntity.ok(like);
    }

    @DeleteMapping("/{playlistId}/unlike")
    public ResponseEntity<Void> unlikePlaylist(@PathVariable Integer playlistId, @RequestHeader("userId") Integer userId) {
        likeService.unlikePlaylist(playlistId, userId);
        return ResponseEntity.noContent().build();
    }
}
