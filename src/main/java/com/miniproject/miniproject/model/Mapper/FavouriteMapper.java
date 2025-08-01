package com.miniproject.miniproject.model.Mapper;

import com.miniproject.miniproject.dto.Response.FavoriteResponse;
import com.miniproject.miniproject.model.Favorite;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FavouriteMapper {
    FavoriteResponse toDTO(Favorite favorite);
}
