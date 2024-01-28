package com.nhnacademy.midoo.gateway.domain;

import java.util.List;
import lombok.Value;

@Value
public class TaskPostRequest {
    String taskTitle;
    String taskContent;
    long projectId;
    long milestoneId;
    String accountId;
    List<Long> tagListId;
}
