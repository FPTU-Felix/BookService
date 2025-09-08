package com.miniproject.miniproject.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusResponse {
    private String id;
    private String statusName;
    private String color;
    private String position;
    private String data;
    private boolean isStart;
    private boolean isEnd;
}
