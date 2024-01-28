package com.nhnacademy.midoo.gateway.domain.comment;

import lombok.Value;

@Value
public class CommentResponse {
    long commentId;
    long taskId;
    String commentContent;
    String accountId;
}
