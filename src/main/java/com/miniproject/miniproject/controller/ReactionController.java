package com.miniproject.miniproject.controller;

import com.miniproject.miniproject.dto.Request.ReactionRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.Social.ReactionResponse;
import com.miniproject.miniproject.model.User;
import com.miniproject.miniproject.security.CustomerUserDetails;
import com.miniproject.miniproject.service.ReactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/library/social")
@RequiredArgsConstructor
public class ReactionController {
    @Autowired
    private ReactionService reactionService;

//    @GetMapping
//    public ApiResponse<List<ReactionResponse>> getAllReaction() {
//        return reactionService.getAllReactions();
//    }

    @PutMapping("/comment/{commentId}/reactions")
    public ResponseEntity<ApiResponse<ReactionResponse>> reactionComment(@PathVariable String commentId,
                                                                         Authentication authentication,
                                                                         @RequestBody @Valid ReactionRequest request) {
        String user_id = authentication.getName();
        ReactionResponse newReaction = reactionService.reactionComment(commentId, user_id, request);
        ApiResponse<ReactionResponse> response = new ApiResponse<>(String.valueOf(HttpStatus.OK), newReaction, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/comment/{commentId}/reactions")
    public ResponseEntity<ApiResponse<ReactionResponse>> removeReactionComment(@PathVariable String commentId,
                                                                               Authentication authentication,
                                                                               @RequestBody @Valid ReactionRequest request) {
        CustomerUserDetails currentUser = (CustomerUserDetails)authentication.getPrincipal();
        reactionService.removeReactionComment(commentId,currentUser.getUserId());
        ApiResponse<ReactionResponse> response = new ApiResponse<>("Deleted Successfully", null, null);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}/reaction")
    public ResponseEntity<ApiResponse<ReactionResponse>> reactionPost(@PathVariable String postId,
                                                                      Authentication authentication,
                                                                      @RequestBody @Valid ReactionRequest request) {
        CustomerUserDetails currentUser = (CustomerUserDetails)authentication.getPrincipal();
        ReactionResponse newReaction = reactionService.reactionPost(postId, currentUser.getUserId(), request);
        ApiResponse<ReactionResponse> response = new ApiResponse<>(String.valueOf(HttpStatus.OK), newReaction, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/reactions")
    public ResponseEntity<ApiResponse<ReactionResponse>> removeReactionPost(@PathVariable String postId,
                                                                            Authentication authentication,
                                                                            @RequestBody @Valid ReactionRequest request) {
        CustomerUserDetails currentUser = (CustomerUserDetails)authentication.getPrincipal();
        reactionService.removeReactionPost(postId,currentUser.getUserId());
        ApiResponse<ReactionResponse> response = new ApiResponse<>("Deleted Successfully", null, null);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
