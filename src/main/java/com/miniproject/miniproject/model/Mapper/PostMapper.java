package com.miniproject.miniproject.model.Mapper;

import com.miniproject.miniproject.dto.Response.Social.PostResponse;
import com.miniproject.miniproject.dto.Response.Social.ReactionResponse;
import com.miniproject.miniproject.model.Post;
import com.miniproject.miniproject.model.PostImage;
import com.miniproject.miniproject.security.CustomerUserDetails;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(source = "postImages", target = "imageUrls")
    @Mapping(source = "user.id", target = "posted_by")
    @Mapping(source = "user.username", target = "userName")
    @Mapping(source = "user.avatar", target = "avatarUrl")
    @Mapping(target = "currentUserReaction", expression = "java(getCurrentUserReaction(post))")

    PostResponse toPostResponse(Post post);

    // Thêm một default method để xử lý logic chuyển đổi
    default List<String> mapImagesToUrls(List<PostImage> images) {
        if (images == null || images.isEmpty()) {
            return Collections.emptyList(); // Trả về danh sách rỗng nếu không có ảnh
        }
        // Lấy ra imgUrl từ mỗi đối tượng PostImage và tạo thành một danh sách String
        return images.stream()
                .map(PostImage::getUrl)
                .collect(Collectors.toList());
    }

    default ReactionResponse getCurrentUserReaction(Post post) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null; // no logged-in user
        }

        Object principal = authentication.getPrincipal();
        String currentUserId = (principal instanceof CustomerUserDetails)
                ? ((CustomerUserDetails) principal).getUserId()
                : null;
        System.out.println("user id");
        if (currentUserId == null) {
            return null;
        }

        return post.getReactions().stream()
                .filter(r -> r.getUser() != null &&
                        r.getUser().getId() != null &&
                        r.getUser().getId().equalsIgnoreCase(currentUserId))
                .map(r -> new ReactionResponse(r.getReaction_id(), r.getType()))
                .findFirst()
                .orElse(null);
    }

}
