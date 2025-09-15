package com.miniproject.miniproject.dto.Request;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizationCreateRequest {
    @NotBlank(message = "Can't leave name blank")
    private String name;
}
