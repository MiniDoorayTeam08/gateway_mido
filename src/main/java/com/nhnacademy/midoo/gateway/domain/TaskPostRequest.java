package com.nhnacademy.midoo.gateway.domain;

import lombok.Value;

@Value
public class TaskPostRequest {
    String taskTitle;
    String taskContent;
    long projectId;
    long milestoneId;
    long accountId;
}
