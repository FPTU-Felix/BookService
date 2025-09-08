package com.miniproject.miniproject.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransitionRequest {
    private String id;
    private String source;
    private String target;
    private String label;
}
