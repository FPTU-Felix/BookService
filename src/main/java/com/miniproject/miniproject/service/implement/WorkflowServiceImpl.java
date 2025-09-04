package com.miniproject.miniproject.service.implement;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miniproject.miniproject.dto.Request.WorkflowUpdateRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.WorkflowResponse;
import com.miniproject.miniproject.exception.ResourceNotFoundException;
import com.miniproject.miniproject.model.Status;
import com.miniproject.miniproject.model.Workflow;
import com.miniproject.miniproject.model.Mapper.WorkflowMapper;
import com.miniproject.miniproject.repository.StatusRepository;
import com.miniproject.miniproject.repository.WorkflowRepository;
import com.miniproject.miniproject.repository.WorkflowTransitionRepository;
import com.miniproject.miniproject.service.WorkflowService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WorkflowServiceImpl implements WorkflowService {

    private WorkflowMapper workflowMapper;
    private WorkflowRepository workflowRepository;
    private StatusRepository statusRepository;
    private WorkflowTransitionRepository workflowTransitionRepository;

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

    @Override
    @Transactional
    public ApiResponse<WorkflowResponse> updateWorkflow(String projectId, WorkflowUpdateRequest request) {
        try {
            Workflow result = workflowRepository.findByProject_Id(projectId)
                    .orElseThrow(() -> new ResourceNotFoundException("Workflow not found"));
            request.getDeletedStatus().stream().forEach(status -> statusRepository.deleteById(status.getId()));
            request.getDeletedTransitions().stream()
                    .forEach(transition -> workflowTransitionRepository.deleteById(transition.getId()));
            request.getUpdatedStatus().stream().forEach(requestStatus -> {
                Status status = statusRepository.findById(requestStatus.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Status not found while updating"));
                status.setStatusName(requestStatus.getStatusName());
                status.setColor(requestStatus.getColor());
                status.setPosition(requestStatus.getPosition());
                status.setData(requestStatus.getData());
                // no .save(), transactional will handle the saving
            });
            return new ApiResponse<>("Success", workflowMapper.toDTO(result));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
