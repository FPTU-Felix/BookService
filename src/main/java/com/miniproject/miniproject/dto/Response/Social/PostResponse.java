package com.miniproject.miniproject.dto.Response.Social;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Data
public class PostResponse extends AuthorGeneralResponse {
    private String id;
    private String posted_by;// sua thanh them userName va avatar
    private String title;
    private String userName;
    private String avatarUrl;
    private String content;
    private List<String> imageUrls;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private int commentCount;
    private int reactionCount;
    private int likeCount;
    private int loveCount;
    private int hahaCount;
    private int sadCount;
    private int wowCount;
    private int angryCount;
    private List<ReactionResponse> reactions;
    private ReactionResponse currentUserReaction;
}
