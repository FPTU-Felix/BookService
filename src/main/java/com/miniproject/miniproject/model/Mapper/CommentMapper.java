package com.miniproject.miniproject.model.Mapper;

import com.miniproject.miniproject.dto.Response.Social.CommentResponse;
import com.miniproject.miniproject.model.Comments;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentResponse toDTO(Comments comments);
}
