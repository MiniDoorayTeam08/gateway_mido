package com.nhnacademy.midoo.gateway.domain.task.entity;

import com.nhnacademy.midoo.gateway.domain.Milestone;
import com.nhnacademy.midoo.gateway.domain.Tag;
import com.nhnacademy.midoo.gateway.domain.Task;
import java.util.List;
import lombok.Data;

@Data
public class ProjectDetail {
    private String projectName;
    private String projectStatus;
    private String projectExplain;
    private List<Task> tasks;
    private List<Milestone> milestones;
    private List<Tag> tags;
}
