package com.nhnacademy.midoo.gateway.domain.task.entity;


import lombok.Data;


@Data
public class ProjectInfo {
    private Long projectId;
    private Long accountId;
    private String name;
    private String status;
    private String description;
}
