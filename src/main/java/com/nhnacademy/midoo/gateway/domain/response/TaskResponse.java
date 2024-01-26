package com.nhnacademy.midoo.gateway.domain.response;

import lombok.Value;

@Value
public class TaskResponse {
    long taskId;
    String taskTitle;
    String taskContent;
    long projectId;
    long milestoneId;
    String accountId;
}
