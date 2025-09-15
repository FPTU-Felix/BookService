package com.miniproject.miniproject.service;

import com.miniproject.miniproject.dto.Request.OrganizationCreateRequest;
import com.miniproject.miniproject.dto.Response.OrgDTO;

public interface OrganizationService {
    OrgDTO getOrganizationById(String organizationId);

    OrgDTO addOrganization(OrganizationCreateRequest organizationCreateRequest, String userId);

    OrgDTO updateOrganization(OrganizationCreateRequest organizationCreateRequest, String userId, String orgId);

    void deleteOrganization(String orgId, String currentUserId);
}
