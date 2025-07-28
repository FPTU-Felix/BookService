package com.miniproject.miniproject.dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Data
@Getter
@Setter
public class BookRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "coverImg is required")
    private String coverImg;
    @NotBlank(message = "price is required")
    private Double price;
    @NotBlank(message = "publishDate is required")
    private String publishDate;
    @NotBlank(message = "createdAt is required")
    private Timestamp createdAt;
    @NotBlank(message = "lastUpdate Type is required")
    private Timestamp lastUpdate;
}
