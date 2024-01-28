package com.nhnacademy.midoo.gateway.service.task;

import com.nhnacademy.midoo.gateway.domain.CommentIdOnly;
import com.nhnacademy.midoo.gateway.domain.CommentPostRequest;
import com.nhnacademy.midoo.gateway.domain.CommentPutRequest;
import com.nhnacademy.midoo.gateway.domain.MilestonePostRequest;
import com.nhnacademy.midoo.gateway.domain.MilestonePutRequest;
import com.nhnacademy.midoo.gateway.domain.TagPostRequest;
import com.nhnacademy.midoo.gateway.domain.TagPutRequest;
import com.nhnacademy.midoo.gateway.domain.Task;
import com.nhnacademy.midoo.gateway.domain.TaskDetailResponse;
import com.nhnacademy.midoo.gateway.domain.TaskDto;
import com.nhnacademy.midoo.gateway.domain.TaskPostRequest;
import com.nhnacademy.midoo.gateway.domain.TaskPutRequest;
import com.nhnacademy.midoo.gateway.domain.response.CommentResponse;
import com.nhnacademy.midoo.gateway.domain.response.MilestoneResponse;
import com.nhnacademy.midoo.gateway.domain.response.TagResponse;
import com.nhnacademy.midoo.gateway.domain.response.TaskResponse;
import java.util.List;

public interface TaskService {
    TaskDto getTaskByTaskId(long taskId);

    List<TaskResponse> getTaskByProjectId(long projectId);

    List<MilestoneResponse> getMilestoneByProjectId(Long projectId);

    List<TagResponse> getTagByProjectId(long projectId);

    List<TagResponse> getTagsByTaskId(long taskId);

    MilestoneResponse getMilestoneByTaskId(long taskId);

    MilestoneResponse getMilestoneByMilestoneId(long milestoneId);

    List<CommentResponse> getCommentsByTaskId(long taskId);

    void putTask(long taskId, TaskPutRequest taskPutRequest);

    void deleteTask(long taskId);

    void postTask(TaskPostRequest taskPostRequest);

    TagResponse getTagByTagId(long tagId);

    List<TagResponse> getTagsByProjectId(long projectId);

    void postTag(long projectId, TagPostRequest tagPostRequest);

    void putTag(long tagId, TagPutRequest tagPutRequest);

    void deleteTag(long tagId);

    void postMilestone(long projectId, MilestonePostRequest milestonePostRequest);

    void putMilestone(long milestoneId, MilestonePutRequest milestonePutRequest);

    void deleteMilestone(long milestoneId);

    CommentResponse getCommentByCommentId(long commentId);

    void postComment(long taskId, CommentPostRequest commentPostRequest);

    void putComment(long commentId, CommentPutRequest commentPutRequest);

    void deleteComment(CommentIdOnly commentIdOnly);

    List<Task> getTasksByAccountId(String accountId);

    TaskDetailResponse getTaskDetail(long taskId);
}
