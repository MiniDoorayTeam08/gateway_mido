package com.nhnacademy.midoo.gateway.domain.project;

import com.nhnacademy.midoo.gateway.domain.milestone.Milestone;
import com.nhnacademy.midoo.gateway.domain.tag.Tag;
import com.nhnacademy.midoo.gateway.domain.task.Task;
import java.util.List;
import lombok.Data;

@Data
public class ProjectDetail {
    private Long projectId;
    private String projectName;
    private String projectStatus;
    private String projectExplain;
    private List<Task> tasks;
    private List<Milestone> milestones;
    private List<Tag> tags;
}
