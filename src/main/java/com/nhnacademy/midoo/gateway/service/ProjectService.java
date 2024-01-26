package com.nhnacademy.midoo.gateway.service;

import com.nhnacademy.midoo.gateway.domain.task.entity.ProjectDetail;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    public ProjectDetail getProjectDetail(Long projectId) {
        return new ProjectDetail();
    }
}
