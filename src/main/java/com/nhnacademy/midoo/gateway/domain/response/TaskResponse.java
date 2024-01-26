package com.nhnacademy.midoo.gateway.domain.response;

import lombok.Value;

@Value
public class TaskResponse {
    Integer taskId;
    String taskTitle;
    String taskContent;
    int projectId;
    int milestoneId;
    int accountId;
}
