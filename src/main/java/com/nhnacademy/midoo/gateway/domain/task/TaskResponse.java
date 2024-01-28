package com.nhnacademy.midoo.gateway.domain.task;

import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(force = true)
public class TaskResponse {
    long taskId;
    String taskTitle;
    String taskContent;
    long projectId;
    long milestoneId;
    String accountId;
}
