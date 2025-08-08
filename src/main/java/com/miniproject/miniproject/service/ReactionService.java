package com.miniproject.miniproject.service;

import com.miniproject.miniproject.dto.Request.ReactionRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.Social.ReactionResponse;

import java.util.List;

public interface ReactionService {
    ApiResponse<List<ReactionResponse>> getAllReactions();

    List<ReactionResponse> getReactionForPost(String post_id);

    ReactionResponse reactionComment(String commentId, String userId, ReactionRequest request);

    ReactionResponse reactionPost(String postId, String userId, ReactionRequest request);

    void removeReactionComment(String commentId, String userId);

    void removeReactionPost(String postId, String userId);
}
