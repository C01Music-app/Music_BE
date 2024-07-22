package com.example.newbe.controller;


import com.example.newbe.service.LikeService.ILikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/likes")
@CrossOrigin("*")  // Allow requests from the frontend
public class LikeController {

    @Autowired
    private ILikesService likeService;

    @PostMapping("/{itemType}/{itemId}/like")
    public ResponseEntity<Void> likeItem(
            @PathVariable String itemType,
            @PathVariable Integer itemId,
            @RequestBody Map<String, Integer> requestBody) {
        Integer userId = requestBody.get("userId");
        if (userId == null) {
            return ResponseEntity.badRequest().build();
        }
        likeService.likeItem(itemType, itemId, userId);
        return ResponseEntity.noContent().build();
    }

    // Endpoint to unlike an item (song or playlist)
    @DeleteMapping("/{itemType}/{itemId}/unlike")
    public ResponseEntity<Void> unlikeItem(
            @PathVariable String itemType,
            @PathVariable Integer itemId,
            @RequestBody Map<String, Integer> requestBody) {
        Integer userId = requestBody.get("userId");
        if (userId == null) {
            return ResponseEntity.badRequest().build();
        }
        likeService.unlikeItem(itemType, itemId, userId);
        return ResponseEntity.noContent().build();
    }

    // Endpoint to check if an item (song or playlist) is liked by a user
    @GetMapping("/check")
    public ResponseEntity<Map<String, Boolean>> checkIfLiked(
            @RequestParam Integer userId,
            @RequestParam Integer itemId,
            @RequestParam String itemType) {
        boolean liked = likeService.checkIfLiked(userId, itemId, itemType);
        Map<String, Boolean> response = new HashMap<>();
        response.put("liked", liked);
        return ResponseEntity.ok(response);
    }
}
