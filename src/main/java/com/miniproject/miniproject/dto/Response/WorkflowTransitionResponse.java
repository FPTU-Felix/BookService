package com.miniproject.miniproject.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkflowTransitionResponse {
    private String id;
    private String source;
    private String target;
    private String label;
}
