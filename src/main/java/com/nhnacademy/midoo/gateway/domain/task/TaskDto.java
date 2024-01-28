package com.nhnacademy.midoo.gateway.domain.task;

import com.nhnacademy.midoo.gateway.domain.milestone.MilestoneResponse;
import lombok.Value;

@Value
public class TaskDto {
    long taskId;
    String taskTitle;
    String taskContent;
    MilestoneResponse milestone;
}
