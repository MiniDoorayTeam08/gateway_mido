package com.nhnacademy.midoo.gateway.domain;

import lombok.Value;

@Value
public class CommentPutRequest {
    int commentId;
    String commentContent;
    int taskId;
    int accountId;
}
