package com.miniproject.miniproject.service.implement;

import com.miniproject.miniproject.dto.Request.ProjectRequest;
import com.miniproject.miniproject.dto.Response.ProjectResponse;
import com.miniproject.miniproject.exception.ResourceNotFoundException;
import com.miniproject.miniproject.model.Mapper.ProjectMapper;
import com.miniproject.miniproject.model.Organization;
import com.miniproject.miniproject.model.Project;
import com.miniproject.miniproject.model.User;
import com.miniproject.miniproject.repository.OrganizationRepository;
import com.miniproject.miniproject.repository.ProjectRepository;
import com.miniproject.miniproject.repository.UserRepository;
import com.miniproject.miniproject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper;
    private final OrganizationRepository organizationRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper, UserRepository userRepository, OrganizationRepository organizationRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.organizationRepository = organizationRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public ProjectResponse getProjectById(String projectId) {
        Project p = projectRepository.findById(projectId).
                orElseThrow(() -> new ResourceNotFoundException("Can't find Post with id =" + projectId));
        return projectMapper.toDto(p);
    }

    @Override
    public List<ProjectResponse> getProjectByUserId(String userId) {
        User u = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Can found User!"));
        List<Project> projects = projectRepository.findAllRelatedProjectsByUserId(userId);
        if (projects.isEmpty()) {
            throw new ResourceNotFoundException("This user" + userId + "hasn't join in any Projects");
        }
        return null;
    }

    @Override
    public ProjectResponse addProject(ProjectRequest projectRequest, String userId) {
        User u = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Can found User!"));
        Project p = projectMapper.toProject(projectRequest);
        Organization o = organizationRepository.findOrganizationByProjectId(p.getId()).orElseThrow(() -> new ResourceNotFoundException("This project doesn't belong to any Organization!"));
        p.setUser(u);
        p.setOrganization(o);
        Project saved = projectRepository.save(p);
        return projectMapper.toDto(saved);
    }

    @Override
    public ProjectResponse updateProject(ProjectRequest projectRequest, String userId) {
        return null;
    }

    @Override
    public void deleteProject(String projectId) {

    }
}
