package com.miniproject.miniproject.dto.Request;

import com.miniproject.miniproject.dto.Response.BookResponse;
import com.miniproject.miniproject.dto.Response.UserDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FavoriteRequest {
    private String id;
    private UserDTO user;
    private BookResponse book;
}
