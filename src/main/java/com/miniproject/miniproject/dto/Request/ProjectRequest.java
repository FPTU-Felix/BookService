package com.miniproject.miniproject.dto.Request;

import jakarta.validation.constraints.NotBlank;

public class ProjectRequest {
    @NotBlank(message = "Can leave project's name blank!")
    private String name;
    @NotBlank(message = "Can leave project's code blank!")
    private String code;
    @NotBlank(message = "Can leave project's description blank!")
    private String description;
}
