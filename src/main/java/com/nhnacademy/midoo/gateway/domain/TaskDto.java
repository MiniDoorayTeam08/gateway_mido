package com.nhnacademy.midoo.gateway.domain;

import com.nhnacademy.midoo.gateway.domain.response.MilestoneResponse;
import lombok.Value;

@Value
public class TaskDto {
    long taskId;
    String taskTitle;
    String taskContent;
    MilestoneResponse milestone;
}
