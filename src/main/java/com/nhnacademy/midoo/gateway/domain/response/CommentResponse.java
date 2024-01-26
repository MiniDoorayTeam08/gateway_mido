package com.nhnacademy.midoo.gateway.domain.response;

import lombok.Value;

@Value
public class CommentResponse {
    long commentId;
    String commentContent;
    long taskId;
    long accountId;
}
