package com.nhnacademy.midoo.gateway.domain.project;

import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(force = true)
public class ProjectResponse {
    Long projectId;
    String accountId;
    String projectStatus;
    String projectName;
    String projectExplain;
}
