package com.nhnacademy.midoo.gateway.domain.task.request.register;


import lombok.Data;

@Data
public class TaskMilestoneCreateRequestDto {

    private Integer taskId;

    private Integer milestoneId;

}