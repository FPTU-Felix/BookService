package com.miniproject.miniproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.miniproject.dto.Request.WorkflowUpdateRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.WorkflowResponse;
import com.miniproject.miniproject.service.WorkflowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/workflow")
@AllArgsConstructor
public class WorkflowController {
    private WorkflowService workflowService;

    @GetMapping("/{id}")
    public ApiResponse<WorkflowResponse> getMethodName(@PathVariable("id") String projectId) {
        return workflowService.getWorkflowOfProject(projectId);
    }

    @PutMapping("/{projectId}")
    public ApiResponse<WorkflowResponse> updateWorkflow(@PathVariable("projectId") String projectId,
            @RequestBody WorkflowUpdateRequest request) {
        return workflowService.updateWorkflow(projectId, request);
    }

}
