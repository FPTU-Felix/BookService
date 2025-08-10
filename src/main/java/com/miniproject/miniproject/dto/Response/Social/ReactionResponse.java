package com.miniproject.miniproject.dto.Response.Social;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReactionResponse {
    private String reaction_id;
    private String type;
}
