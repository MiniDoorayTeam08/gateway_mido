package com.nhnacademy.midoo.gateway.domain;

import lombok.Data;

@Data
public class Task {
    private Long taskId;
    private String context;
    private Long projectId;
    private Long mileStonrId;
    private String accountId;

}