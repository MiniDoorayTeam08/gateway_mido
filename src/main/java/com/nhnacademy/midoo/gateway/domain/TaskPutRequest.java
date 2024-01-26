package com.nhnacademy.midoo.gateway.domain;

import lombok.Value;

@Value
public class TaskPutRequest {
    long taskId;
    String taskTitle;
    String taskContent;
    long projectId;
    long milestoneId;
    long accountId;
}
