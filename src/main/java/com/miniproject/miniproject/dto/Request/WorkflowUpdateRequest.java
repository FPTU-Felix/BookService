package com.miniproject.miniproject.dto.Request;

import java.util.List;

import com.miniproject.miniproject.model.Status;
import com.miniproject.miniproject.model.WorkFlowTransition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WorkflowUpdateRequest {
    private List<Status> addedStatus;
    private List<Status> updatedStatus;
    private List<Status> deletedStatus;
    private List<WorkFlowTransition> addedTransitions;
    private List<WorkFlowTransition> updatedTransitions;
    private List<WorkFlowTransition> deletedTransitions;
}
