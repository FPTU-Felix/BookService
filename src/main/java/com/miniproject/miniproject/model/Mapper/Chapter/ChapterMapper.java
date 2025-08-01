package com.miniproject.miniproject.model.Mapper.Chapter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.miniproject.miniproject.dto.Response.Chapter.ChapterResponse;
import com.miniproject.miniproject.model.Chapter;

@Mapper(componentModel = "spring")
public interface ChapterMapper {
    @Mapping(target = "coverImage", expression = "java(getChapterCoverImage(chapter))")
    ChapterResponse toDTO(Chapter chapter);

    default String getChapterCoverImage(Chapter chapter) {
        try {
            if (chapter.getImages() == null || chapter.getImages() == "") {
                return "https://www.svgrepo.com/show/508699/landscape-placeholder.svg";
            }
            return chapter.getImages().split(",")[0];
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
