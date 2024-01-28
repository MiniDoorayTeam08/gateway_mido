package com.nhnacademy.midoo.gateway.domain.comment;

import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(force = true)
public class CommentResponse {
    long commentId;
    long taskId;
    String commentContent;
    String accountId;
}
