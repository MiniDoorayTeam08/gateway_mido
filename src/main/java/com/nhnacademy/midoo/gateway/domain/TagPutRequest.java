package com.nhnacademy.midoo.gateway.domain;

import lombok.Value;

@Value
public class TagPutRequest {
    long tagId;
    String tagName;
    long projectId;
}