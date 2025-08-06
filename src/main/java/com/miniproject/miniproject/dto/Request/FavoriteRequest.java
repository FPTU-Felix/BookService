package com.miniproject.miniproject.dto.Request;

import com.miniproject.miniproject.dto.Response.Book.BookResponse;
import com.miniproject.miniproject.dto.Response.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavoriteRequest {
    private String id;
    private UserDTO user;
    private BookResponse book;
}
