package com.miniproject.miniproject.dto.Response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WorkflowResponse {
    private String id;
    private String workFlowName;
    private List<StatusResponse> statuses;
    private List<WorkflowTransitionResponse> workFlowTransitions;
}
