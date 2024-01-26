package com.nhnacademy.midoo.gateway.config.task;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "api.task")
@Getter
@Setter
public class TaskApiServerProperties {
    String url;
    String port;
    String getProject;
    String putProject;
    String delProject;
    String getProjects;
    String postProject;
    String getTask;
    String postTask;
    String putTask;
    String delTask;
    String authTask;

    String getMilestone;
    String postMilestone;
    String putMilestone;
    String delMilestone;
    String authMilestone;

    String getComment;
    String postComment;
    String putComment;
    String delComment;
    String authComment;

    String getTag;
    String postTag;
    String putTag;
    String delTag;
    String authTag;


    String postTaskMilestone;

    String delTaskMilestone;


    public String getFullUrl() {
        return getUrl() + ":" + getPort();
    }
}
