package com.miniproject.miniproject.model.Mapper;

import com.miniproject.miniproject.dto.Response.Book.BookResponse;
import com.miniproject.miniproject.dto.Response.CategoryResponse;
import com.miniproject.miniproject.model.Book;
import com.miniproject.miniproject.model.Chapter;
import com.miniproject.miniproject.model.Rate;
import com.miniproject.miniproject.model.Mapper.Chapter.ChapterMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PublisherMapper.class, FavouriteMapper.class, ChapterMapper.class})
public interface BookMapper {
    @Mapping(target = "categories", expression = "java(getCategories(book))")
    @Mapping(target = "rate", expression = "java(getAverageRating(book))")
    @Mapping(target = "viewCount", expression = "java(getViewCount(book))")
    BookResponse toDTO(Book book);

    default double getAverageRating(Book b) {
        try {
            if (b.getRate().isEmpty()) {
                return 0.0;
            }
            return b.getRate().stream().mapToDouble(Rate::getScore).average().orElse(0.0);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    default Integer getViewCount(Book b) {
        try {
            return b.getChapters().stream().mapToInt(Chapter::getView).sum();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    default List<CategoryResponse> getCategories(Book b) {
        try {
            return b.getBookCategories().stream().map(bc -> new CategoryResponse(bc.getCategory().getId(), bc.getCategory().getName())).toList();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
