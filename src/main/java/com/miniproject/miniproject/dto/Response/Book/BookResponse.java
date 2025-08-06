package com.miniproject.miniproject.dto.Response.Book;

import com.miniproject.miniproject.dto.Response.CategoryResponse;
import com.miniproject.miniproject.dto.Response.Chapter.ChapterResponse;
import com.miniproject.miniproject.dto.Response.FavoriteResponse;
import com.miniproject.miniproject.dto.Response.PublisherResponse;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private String id;
    private String name;
    private String coverImg;
    private Double price;
    private String publishDate;
    private List<CategoryResponse> categories;
    private Double rate;
    private PublisherResponse publisher;
    private List<FavoriteResponse> favorites;
    private List<ChapterResponse> chapters;
    private Integer viewCount;
}
