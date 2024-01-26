package com.nhnacademy.midoo.gateway.domain.task.request.register;

import lombok.Data;

@Data
public class CommentCreateDto {

    private Integer taskId;

    private String writerId;

    private String content;
}
