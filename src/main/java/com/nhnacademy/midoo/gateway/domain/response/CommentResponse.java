package com.nhnacademy.midoo.gateway.domain.response;

import lombok.Value;

@Value
public class CommentResponse {
    int commentId;
    String commentContent;
    int taskId;
    int accountId;
}
