package com.nhnacademy.midoo.gateway.service.task;

import com.nhnacademy.midoo.gateway.domain.project.ProjectDetail;
import com.nhnacademy.midoo.gateway.domain.project.ProjectInfo;
import com.nhnacademy.midoo.gateway.domain.project.ProjectPostRequest;
import com.nhnacademy.midoo.gateway.domain.project.ProjectResponse;
import java.util.List;

public interface ProjectService {
    List<ProjectInfo> getProjectsByAccountId(String projectId);

    ProjectDetail createProject(ProjectPostRequest projectPostRequest);

    ProjectResponse getProjectDetail(Long projectId);
}
