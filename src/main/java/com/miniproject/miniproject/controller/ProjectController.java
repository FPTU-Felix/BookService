package com.miniproject.miniproject.controller;

import com.miniproject.miniproject.dto.Request.ProjectRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.ProjectResponse;
import com.miniproject.miniproject.security.CustomerUserDetails;
import com.miniproject.miniproject.service.ProjectService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
@AllArgsConstructor
public class ProjectController {
    private ProjectService projectService;

    @GetMapping("/detail/{projectId}")
    public ResponseEntity<ApiResponse<ProjectResponse>> getProjectById(@PathVariable("projectId") String projectId) {
        ProjectResponse p = projectService.getProjectById(projectId);
        ApiResponse<ProjectResponse> response = new ApiResponse<>("Sucess", p, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<List<ProjectResponse>>> getProjectByUserId(@PathVariable String userId) {
        List<ProjectResponse> list = projectService.getProjectByUserId(userId);
        ApiResponse<List<ProjectResponse>> response = new ApiResponse<>("Sucess", list, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<ProjectResponse>> addProject(@RequestBody @Valid ProjectRequest projectRequest, Authentication authentication) {
        CustomerUserDetails currentUser = (CustomerUserDetails) authentication.getPrincipal();
        ProjectResponse projectResponse = projectService.addProject(projectRequest, currentUser.getUserId());
        ApiResponse<ProjectResponse> apiResponse = new ApiResponse<>("Sucess", projectResponse, null);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PatchMapping("/{projectId}")
    public ResponseEntity<ApiResponse<ProjectResponse>> updateProject(@RequestBody @Valid ProjectRequest projectRequest, Authentication authentication, @PathVariable String projectId) {
        CustomerUserDetails currentUser = (CustomerUserDetails) authentication.getPrincipal();
        ProjectResponse projectResponse = projectService.updateProject(projectRequest, currentUser.getUserId(), projectId);
        ApiResponse<ProjectResponse> apiResponse = new ApiResponse<>("Sucess", projectResponse, null);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @DeleteMapping("/{projectId}")
    public ResponseEntity<ApiResponse<?>> deleteProject(@PathVariable String projectId, Authentication authentication){
        CustomerUserDetails currentUser = (CustomerUserDetails) authentication.getPrincipal();
        projectService.deleteProject(projectId, currentUser.getUserId());
        ApiResponse<ProjectResponse> apiResponse = new ApiResponse<>("Sucess", null, null);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
