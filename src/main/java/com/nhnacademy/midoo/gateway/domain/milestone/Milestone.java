package com.nhnacademy.midoo.gateway.domain.milestone;

import lombok.Data;

@Data
public class Milestone {
    private Long mileStoneId;
    private String name;
    private Long projectId;
}
