package com.miniproject.miniproject.model.Mapper.Chapter;

import org.mapstruct.Mapper;

import com.miniproject.miniproject.dto.Response.Chapter.ChapterDetailResponse;
import com.miniproject.miniproject.model.Chapter;
import com.miniproject.miniproject.model.Mapper.BookMapper;

@Mapper(componentModel = "spring", uses = { BookMapper.class })
public interface ChapterDetailMapper {
    ChapterDetailResponse toDTO (Chapter chapter);
}
