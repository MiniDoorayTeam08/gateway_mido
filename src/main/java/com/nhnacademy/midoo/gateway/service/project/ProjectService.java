package com.nhnacademy.midoo.gateway.service.project;

import com.nhnacademy.midoo.gateway.domain.ProjectPostRequest;
import com.nhnacademy.midoo.gateway.domain.task.entity.ProjectDetail;
import com.nhnacademy.midoo.gateway.domain.task.entity.ProjectInfo;
import java.util.List;

public interface ProjectService {
    List<ProjectInfo> getProjectsByAccountId(String projectId);

    ProjectDetail createProject(ProjectPostRequest projectPostRequest);

    ProjectDetail getProjectDetail(Long projectId);
}
