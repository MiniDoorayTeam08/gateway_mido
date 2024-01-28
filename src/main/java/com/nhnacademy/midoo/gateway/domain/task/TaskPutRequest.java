package com.nhnacademy.midoo.gateway.domain.task;

import java.util.List;
import lombok.Value;

@Value
public class TaskPutRequest {
    String taskTitle;

    String taskContent;

    Long projectId;

    Long milestoneId;

    List<Long> tagListId;

    String accountId;
}
