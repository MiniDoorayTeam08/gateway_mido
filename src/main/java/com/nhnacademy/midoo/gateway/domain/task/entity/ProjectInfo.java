package com.nhnacademy.midoo.gateway.domain.task.entity;


import lombok.Data;


@Data
public class ProjectInfo {
    private Long projectId;
    private String accountId;
    private String projectName;
    private String projectStatus;
    private String projectExplain;
}
