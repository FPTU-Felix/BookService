package com.miniproject.miniproject.model.Mapper;

import com.miniproject.miniproject.dto.Request.OrganizationCreateRequest;
import com.miniproject.miniproject.dto.Response.OrgDTO;
import com.miniproject.miniproject.model.Organization;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {
    OrgDTO toDto(Organization organization);

    Organization toOrg(OrganizationCreateRequest organizationCreateRequest);
}
