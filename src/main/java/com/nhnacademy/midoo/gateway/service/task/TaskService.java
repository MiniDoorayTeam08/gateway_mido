package com.nhnacademy.midoo.gateway.service.task;

import com.nhnacademy.midoo.gateway.domain.CommentIdOnly;
import com.nhnacademy.midoo.gateway.domain.CommentPostRequest;
import com.nhnacademy.midoo.gateway.domain.CommentPutRequest;
import com.nhnacademy.midoo.gateway.domain.MilestonePostRequest;
import com.nhnacademy.midoo.gateway.domain.MilestonePutRequest;
import com.nhnacademy.midoo.gateway.domain.TagPostRequest;
import com.nhnacademy.midoo.gateway.domain.TagPutRequest;
import com.nhnacademy.midoo.gateway.domain.Task;
import com.nhnacademy.midoo.gateway.domain.TaskPostRequest;
import com.nhnacademy.midoo.gateway.domain.TaskPutRequest;
import com.nhnacademy.midoo.gateway.domain.response.CommentResponse;
import com.nhnacademy.midoo.gateway.domain.response.MilestoneResponse;
import com.nhnacademy.midoo.gateway.domain.response.TagResponse;
import com.nhnacademy.midoo.gateway.domain.response.TaskResponse;
import java.util.List;

public interface TaskService {
    TaskResponse getTaskByTaskId(long taskId);

    List<TaskResponse> getTaskByProjectId(long projectId);

    List<MilestoneResponse> getMilestoneByProjectId(Long projectId);

    List<TagResponse> getTagByProjectId(long projectId);

    List<TagResponse> getTagsByTaskId(long taskId);

    MilestoneResponse getMilestoneByTaskId(long taskId);

    List<CommentResponse> getCommentsByTaskId(long taskId);

    void putTask(long taskId, TaskPutRequest taskPutRequest);

    void deleteTask(long taskId);

    void postTask(TaskPostRequest taskPostRequest);

    TagResponse getTagByTagId(long tagId);

    void postTag(TagPostRequest tagPostRequest);

    void putTag(long tagId, TagPutRequest tagPutRequest);

    void deleteTag(long tagId);

    void postMilestone(long projectId, MilestonePostRequest milestonePostRequest);

    void putMilestone(long milestoneId, MilestonePutRequest milestonePutRequest);

    void deleteMilestone(long milestoneId);

    CommentResponse getCommentByCommentId(long commentId);

    void postComment(CommentPostRequest commentPostRequest);

    void putComment(CommentPutRequest commentPutRequest);

    void deleteComment(CommentIdOnly commentIdOnly);

    List<Task> getTasksByAccountId(String accountId);
}
