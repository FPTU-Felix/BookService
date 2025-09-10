package com.miniproject.miniproject.service;

import com.miniproject.miniproject.dto.Request.ProjectRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.ProjectResponse;

import java.util.List;

public interface ProjectService {

    ProjectResponse getProjectById(String projectId);

    List<ProjectResponse> getProjectByUserId(String userId);

    ProjectResponse addProject(ProjectRequest projectRequest, String userId);

    ProjectResponse updateProject(ProjectRequest projectRequest, String userId, String projectId);

    void deleteProject(String projectId);

}
