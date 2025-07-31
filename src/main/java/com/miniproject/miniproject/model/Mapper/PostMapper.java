package com.miniproject.miniproject.model.Mapper;

import com.miniproject.miniproject.dto.Response.PostResponse;
import com.miniproject.miniproject.model.Post;
import com.miniproject.miniproject.model.PostImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(source = "postImages", target = "imageUrls")
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
}
