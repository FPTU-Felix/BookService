package com.miniproject.miniproject.dto.Response.Chapter;

import java.time.LocalDateTime;

import com.miniproject.miniproject.dto.Response.Book.BookResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChapterDetailResponse {
    private String id;
    private LocalDateTime created_at;
    private String chapter_name;
    private String publish_at;
    private String type;
    private Integer view;
    private LocalDateTime updated_at;
    private String coverImage;
    private Integer chapterIndex;
    private String images;
    private BookResponse book;
}
