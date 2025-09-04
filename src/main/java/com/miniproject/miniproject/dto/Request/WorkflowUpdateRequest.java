package com.miniproject.miniproject.dto.Request;

import java.util.ArrayList;
import java.util.List;

import com.miniproject.miniproject.model.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkflowUpdateRequest {
    private List<Status> addedStatus = new ArrayList<>();
    private List<Status> updatedStatus = new ArrayList<>();
    private List<Status> deletedStatus = new ArrayList<>();
    private List<TransitionRequest> addedTransitions = new ArrayList<>();
    private List<TransitionRequest> updatedTransitions;
    private List<TransitionRequest> deletedTransitions = new ArrayList<>();
}
