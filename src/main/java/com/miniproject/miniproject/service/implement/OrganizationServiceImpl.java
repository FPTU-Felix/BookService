package com.miniproject.miniproject.service.implement;

import com.miniproject.miniproject.dto.Request.OrganizationCreateRequest;
import com.miniproject.miniproject.dto.Response.OrgDTO;
import com.miniproject.miniproject.exception.ResourceNotFoundException;
import com.miniproject.miniproject.model.Mapper.OrganizationMapper;
import com.miniproject.miniproject.model.Organization;
import com.miniproject.miniproject.model.User;
import com.miniproject.miniproject.repository.OrganizationRepository;
import com.miniproject.miniproject.repository.UserRepository;
import com.miniproject.miniproject.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;
    private final UserRepository userRepository;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository, OrganizationMapper organizationMapper, UserRepository userRepository) {
        this.organizationRepository = organizationRepository;
        this.organizationMapper = organizationMapper;
        this.userRepository = userRepository;
    }

    @Override
    public OrgDTO getOrganizationById(String organizationId) {
        Organization o = organizationRepository.findById(organizationId).orElseThrow(() -> new ResourceNotFoundException("Can't found Organization with id=" + organizationId));
        return organizationMapper.toDto(o);
    }

    @Override
    public OrgDTO addOrganization(OrganizationCreateRequest organizationCreateRequest, String userId) {
        User u = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Can't found User with id=" + userId));
        Organization o = organizationMapper.toOrg(organizationCreateRequest);
        Organization saved = organizationRepository.save(o);
        return organizationMapper.toDto(saved);
    }

    @Override
    public OrgDTO updateOrganization(OrganizationCreateRequest organizationCreateRequest, String userId, String orgId) {
        return null;
    }

    @Override
    public void deleteOrganization(String orgId, String currentUserId) {

    }
}
