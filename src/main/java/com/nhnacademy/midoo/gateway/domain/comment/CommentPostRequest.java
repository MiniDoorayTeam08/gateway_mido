package com.nhnacademy.midoo.gateway.domain.comment;

import lombok.Data;

@Data
public class CommentPostRequest {
    String commentContent;
    String accountId;
}
