package com.miniproject.miniproject.dto.Response.Social;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Data
public class PostResponse extends AuthorGeneralResponse{
    private String id;
    private String posted_by;//sua thanh them userName va avatar
    private String title;
    private String content;
    private List<String> imageUrls;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
