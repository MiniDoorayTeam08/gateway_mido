package com.nhnacademy.midoo.gateway.service;

import com.nhnacademy.midoo.gateway.domain.task.entity.ProjectDetail;


public interface ProjectService {
    ProjectDetail getProjectDetail(Long projectId);
 
    void createProject(ProjectDetail projectDetail);

    void editProject(Long projectId, ProjectDetail updatedProjectDetail);
}
