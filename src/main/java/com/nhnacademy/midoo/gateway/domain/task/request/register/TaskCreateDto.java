package com.nhnacademy.midoo.gateway.domain.task.request.register;

import lombok.Data;

@Data
public class TaskCreateDto {

    private String title;

    private String content;

    private String writerId;

    private Integer projectId;
}