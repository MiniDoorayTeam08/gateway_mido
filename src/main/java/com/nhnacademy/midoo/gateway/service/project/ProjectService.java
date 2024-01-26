package com.nhnacademy.midoo.gateway.service.project;

import com.nhnacademy.midoo.gateway.domain.task.entity.ProjectInfo;
import java.util.List;

public interface ProjectService {
    List<ProjectInfo> getProjectsByAccountId(String projectId);
}
