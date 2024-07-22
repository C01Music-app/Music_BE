package com.example.newbe.service.LikeService;

public interface ILikesService  {

    void likeItem(String itemType, Integer itemId, Integer userId);

    void unlikeItem(String itemType, Integer itemId, Integer userId);

    boolean checkIfLiked(Integer userId, Integer itemId, String itemType);
}
