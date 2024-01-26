package com.nhnacademy.midoo.gateway.domain;

import lombok.Data;

@Data
public class Tag {
    private Long tagId;
    private String tagName;
    private Long projectId;
}
