package com.miniproject.miniproject.model.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.miniproject.miniproject.dto.Request.StatusRequest;
import com.miniproject.miniproject.dto.Response.StatusResponse;
import com.miniproject.miniproject.model.Status;

@Mapper(componentModel = "spring")
public interface StatusMapper {

    StatusResponse toDTO(Status status);

    @Mapping(target = "workFlow", ignore = true)
    Status toEntity(StatusRequest statusRequest);
}
