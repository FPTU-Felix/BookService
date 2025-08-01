package com.miniproject.miniproject.dto.Response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class FavoriteResponse {
    private String id;
    private UserDTO user;
    
}
