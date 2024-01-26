package com.nhnacademy.midoo.gateway.domain;

import lombok.Value;

@Value
public class TagPutRequest {
    Integer tagId;
    String tagName;
    int projectId;
}