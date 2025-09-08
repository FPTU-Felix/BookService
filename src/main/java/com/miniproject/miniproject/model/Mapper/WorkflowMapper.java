package com.miniproject.miniproject.model.Mapper;

import org.mapstruct.Mapper;

import com.miniproject.miniproject.dto.Response.WorkflowResponse;
import com.miniproject.miniproject.model.Workflow;

@Mapper(componentModel = "spring", uses = { StatusMapper.class, WorkflowTransitionMapper.class })
public interface WorkflowMapper {
    WorkflowResponse toDTO(Workflow workflow);
}
