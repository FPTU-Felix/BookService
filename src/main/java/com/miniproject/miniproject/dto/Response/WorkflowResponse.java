package com.miniproject.miniproject.dto.Response;

import java.util.List;

import com.miniproject.miniproject.model.Status;
import com.miniproject.miniproject.model.WorkFlowTransition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WorkflowResponse {
    private String id;
    private String workFlowName;
    private List<Status> statuses;
    private List<WorkFlowTransition> workFlowTransitions;
}
