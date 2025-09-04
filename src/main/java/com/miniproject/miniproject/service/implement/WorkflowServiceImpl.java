package com.miniproject.miniproject.service.implement;

import org.springframework.stereotype.Service;

import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.WorkflowResponse;
import com.miniproject.miniproject.exception.ResourceNotFoundException;
import com.miniproject.miniproject.model.Workflow;
import com.miniproject.miniproject.model.Mapper.WorkflowMapper;
import com.miniproject.miniproject.repository.WorkflowRepository;
import com.miniproject.miniproject.service.WorkflowService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WorkflowServiceImpl implements WorkflowService {

    private WorkflowMapper workflowMapper;
    private WorkflowRepository workflowRepository;

    @Override
    public ApiResponse<WorkflowResponse> getWorkflowOfProject(String projectId) {
        try {
            Workflow result = workflowRepository.findByProject_Id(projectId)
                    .orElseThrow(() -> new ResourceNotFoundException("Workflow not found"));
            return new ApiResponse<>("Success", workflowMapper.toDTO(result));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
