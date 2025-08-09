package com.miniproject.miniproject.dto.Response.Social;

import com.miniproject.miniproject.dto.Response.UserDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class CommentResponse {
    private String id;
    private String content;
    private UserDTO user;
    private int replyCount;
    private String parentCommentId;
    private int likeCount;
    private int loveCount;
    private int hahaCount;
    private int sadCount;
    private int wowCount;
    private int angryCount;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
