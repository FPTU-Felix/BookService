package com.miniproject.miniproject.model.Mapper;

import org.mapstruct.Mapper;

import com.miniproject.miniproject.dto.Response.ChapterResponse;
import com.miniproject.miniproject.model.Chapter;

@Mapper(componentModel = "spring")
public interface ChapterMapper {
    ChapterResponse toDTO(Chapter chapter);
}
