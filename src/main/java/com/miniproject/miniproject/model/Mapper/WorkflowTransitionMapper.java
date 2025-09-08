package com.miniproject.miniproject.model.Mapper;

import org.mapstruct.Mapper;

import com.miniproject.miniproject.dto.Request.TransitionRequest;
import com.miniproject.miniproject.dto.Response.WorkflowTransitionResponse;
import com.miniproject.miniproject.model.WorkFlowTransition;

@Mapper(componentModel = "spring")
public interface WorkflowTransitionMapper {
    
    WorkflowTransitionResponse toDTO(WorkFlowTransition workFlowTransition);

    WorkFlowTransition toEntity(TransitionRequest transitionRequest);
}