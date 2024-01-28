package com.nhnacademy.midoo.gateway.domain.tag;

import lombok.Data;

@Data
public class Tag {
    private Long tagId;
    private String tagName;
    private Long projectId;
}
