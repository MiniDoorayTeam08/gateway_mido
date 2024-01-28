package com.nhnacademy.midoo.gateway.service.task;

import com.nhnacademy.midoo.gateway.domain.comment.CommentIdOnly;
import com.nhnacademy.midoo.gateway.domain.comment.CommentPostRequest;
import com.nhnacademy.midoo.gateway.domain.comment.CommentPutRequest;
import com.nhnacademy.midoo.gateway.domain.comment.CommentResponse;
import com.nhnacademy.midoo.gateway.domain.milestone.MilestonePostRequest;
import com.nhnacademy.midoo.gateway.domain.milestone.MilestonePutRequest;
import com.nhnacademy.midoo.gateway.domain.milestone.MilestoneResponse;
import com.nhnacademy.midoo.gateway.domain.tag.TagPostRequest;
import com.nhnacademy.midoo.gateway.domain.tag.TagPutRequest;
import com.nhnacademy.midoo.gateway.domain.tag.TagResponse;
import com.nhnacademy.midoo.gateway.domain.task.Task;
import com.nhnacademy.midoo.gateway.domain.task.TaskDetailResponse;
import com.nhnacademy.midoo.gateway.domain.task.TaskDto;
import com.nhnacademy.midoo.gateway.domain.task.TaskPostRequest;
import com.nhnacademy.midoo.gateway.domain.task.TaskPutRequest;
import com.nhnacademy.midoo.gateway.domain.task.TaskResponse;
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
