package com.nhnacademy.midoo.gateway.domain;

import lombok.Data;

@Data
public class CommentPostRequest {
    String commentContent;
    String accountId;
}
