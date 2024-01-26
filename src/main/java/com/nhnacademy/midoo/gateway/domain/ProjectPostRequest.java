package com.nhnacademy.midoo.gateway.domain;

import java.util.List;
import lombok.Value;

@Value
public class ProjectPostRequest {
    String accountId;
    String projectName;
    String projectStatus;
    String projectExplain;
    List<String> projectMemberIdList;
}
