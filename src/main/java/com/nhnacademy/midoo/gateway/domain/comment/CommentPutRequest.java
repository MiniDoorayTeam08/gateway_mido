package com.nhnacademy.midoo.gateway.domain.comment;

import lombok.Value;

@Value
public class CommentPutRequest {
    String commentContent;
    String accountId;
}
