package com.nhnacademy.midoo.gateway.domain;

import lombok.Value;

@Value
public class CommentPostRequest {
    String commentContent;
    long taskId;
    long accountId;
}
