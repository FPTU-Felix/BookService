package com.miniproject.miniproject.dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectRequest {
    @NotBlank(message = "Can leave project's name blank!")
    private String name;
    @NotBlank(message = "Can leave project's code blank!")
    private String code;
    @NotBlank(message = "Can leave project's description blank!")
    private String description;
    @NotBlank(message = "Can leave project organizaton blank!")
    private String organizationId;
}
