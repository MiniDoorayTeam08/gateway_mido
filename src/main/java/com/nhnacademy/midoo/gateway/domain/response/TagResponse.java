package com.nhnacademy.midoo.gateway.domain.response;

import lombok.Value;

@Value
public class TagResponse {
    int commentId;
    String commentContent;
    int taskId;
    int accountId;
}