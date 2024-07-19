package com.example.newbe.controller;

import com.example.newbe.model.Likes;
import com.example.newbe.service.LikeService.ILikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/likes")
public class LikesController {
    @Autowired
    private ILikesService likesService;

    @PostMapping("/song")
    public ResponseEntity<Likes> likeSong(@RequestBody Likes like) {
        Likes savedLike = likesService.likeSong(like);
        return ResponseEntity.ok(savedLike);
    }

    @DeleteMapping("/song")
    public ResponseEntity<Void> unlikeSong(@RequestParam Integer userId, @RequestParam Integer songId) {
        likesService.unlikeSong(userId, songId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/playlist")
    public ResponseEntity<Likes> likePlaylist(@RequestBody Likes like) {
        Likes savedLike = likesService.likePlaylist(like);
        return ResponseEntity.ok(savedLike);
    }

    @DeleteMapping("/playlist")
    public ResponseEntity<Void> unlikePlaylist(@RequestParam Integer userId, @RequestParam Integer playlistId) {
        likesService.unlikePlaylist(userId, playlistId);
        return ResponseEntity.noContent().build();
    }
}
