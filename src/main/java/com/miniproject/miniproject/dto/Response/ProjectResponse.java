package com.miniproject.miniproject.dto.Response;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProjectResponse {
    private String id;
    private String name;
    private String code;
    private String description;
    private UserDTO user;
    private OrgDTO org;
    private WorkflowDTO workflow;
}
