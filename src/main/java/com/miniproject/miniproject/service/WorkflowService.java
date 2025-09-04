package com.miniproject.miniproject.service;

import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.WorkflowResponse;

public interface WorkflowService {
    ApiResponse<WorkflowResponse> getWorkflowOfProject(String projectId);
}
