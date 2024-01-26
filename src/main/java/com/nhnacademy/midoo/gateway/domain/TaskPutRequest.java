package com.nhnacademy.midoo.gateway.domain;

import lombok.Value;

@Value
public class TaskPutRequest {
    Integer taskId;
    String taskTitle;
    String taskContent;
    int projectId;
    int milestoneId;
    int accountId;
}
