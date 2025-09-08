package com.miniproject.miniproject.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StatusRequest {
    private String id;
    private String statusName;
    private String color;
    private String position;
    private String data;
    private boolean isStart;
    private boolean isEnd;
    private String workflowId;
}
