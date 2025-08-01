package com.miniproject.miniproject.dto.Response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ChapterResponse {
    private String id;
    private LocalDateTime created_at;
    private String chapter_name;
    private String next_chapter;
    private String publish_at;
    private String type;
    private Integer view;
    private LocalDateTime updated_at;
}
