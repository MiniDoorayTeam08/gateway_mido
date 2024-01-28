package com.nhnacademy.midoo.gateway.domain.project;

import lombok.Value;

@Value
public class ProjectResponse {
    Long projectId;
    String accountId;
    String projectStatus;
    String projectName;
    String projectExplain;
}
