package com.miniproject.miniproject.model.Mapper;

import com.miniproject.miniproject.dto.Request.ProjectRequest;
import com.miniproject.miniproject.dto.Response.ProjectResponse;
import com.miniproject.miniproject.model.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectResponse toDto(Project project);
    Project toProject(ProjectRequest projectRequest);
}
