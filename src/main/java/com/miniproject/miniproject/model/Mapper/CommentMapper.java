package com.miniproject.miniproject.model.Mapper;

import com.miniproject.miniproject.dto.Response.Social.CommentResponse;
import com.miniproject.miniproject.model.Comments;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface CommentMapper {
    @Mapping(source = "user", target = "user") // user (Entity) -> user (UserDTO)
    @Mapping(source = "repliedTo.id", target = "parentCommentId") // Lấy id của comment cha
    @Mapping(source = "createdAt", target = "created_at") // Ánh xạ createdAt -> created_at
    @Mapping(source = "updatedAt", target = "updated_at")
    CommentResponse toDTO(Comments comments);
}
