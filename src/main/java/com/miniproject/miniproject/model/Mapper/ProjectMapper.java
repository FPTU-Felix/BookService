package com.miniproject.miniproject.model.Mapper;

import com.miniproject.miniproject.dto.Request.ProjectRequest;
import com.miniproject.miniproject.dto.Response.ProjectResponse;
import com.miniproject.miniproject.model.Project;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectResponse toDto(Project project);
    Project toProject(ProjectRequest projectRequest);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProjectFromDto(ProjectRequest dto, @MappingTarget Project entity);
    //@MappingTarget: Báo cho MapStruct không tạo đối tượng mới mà hãy cập nhật vào entity đã có.
    //@BeanMapping(...): Giúp bỏ qua các trường null từ DTO, để bạn không vô tình ghi đè dữ liệu đã có bằng null
}
