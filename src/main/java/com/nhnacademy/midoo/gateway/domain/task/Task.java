package com.nhnacademy.midoo.gateway.domain.task;

import lombok.Data;

@Data
public class Task {
    private Long taskId;
    private String context;
    private Long projectId;
    private Long milestoneId;
    private String accountId;
    private String name;
}
