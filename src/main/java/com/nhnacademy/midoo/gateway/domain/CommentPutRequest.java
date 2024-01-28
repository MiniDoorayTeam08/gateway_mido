package com.nhnacademy.midoo.gateway.domain;

import lombok.Value;

@Value
public class CommentPutRequest {
    String commentContent;
    String accountId;
}
