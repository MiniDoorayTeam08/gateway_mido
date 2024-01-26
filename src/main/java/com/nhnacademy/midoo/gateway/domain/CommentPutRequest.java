package com.nhnacademy.midoo.gateway.domain;

import lombok.Value;

@Value
public class CommentPutRequest {
    long commentId;
    String commentContent;
    long taskId;
    long accountId;
}
