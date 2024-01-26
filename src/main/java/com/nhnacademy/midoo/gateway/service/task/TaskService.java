package com.nhnacademy.midoo.gateway.service.task;

import com.nhnacademy.midoo.gateway.domain.CommentIdOnly;
import com.nhnacademy.midoo.gateway.domain.CommentPostRequest;
import com.nhnacademy.midoo.gateway.domain.CommentPutRequest;
import com.nhnacademy.midoo.gateway.domain.MilestonePostRequest;
import com.nhnacademy.midoo.gateway.domain.MilestonePutRequest;
import com.nhnacademy.midoo.gateway.domain.TagPostRequest;
import com.nhnacademy.midoo.gateway.domain.TagPutRequest;
import com.nhnacademy.midoo.gateway.domain.TaskPostRequest;
import com.nhnacademy.midoo.gateway.domain.TaskPutRequest;
import java.util.List;

public interface TaskService {
    TaskPutRequest getTaskByTaskId(int taskId);

    List<TagPutRequest> getTagsByTaskId(int taskId);

    MilestonePutRequest getMilestoneByTaskId(int taskId);

    List<CommentPutRequest> getCommentsByTaskId(int taskId);

    void putTask(int taskId, TaskPutRequest taskPutRequest);

    void deleteTask(int taskId);

    void postTask(TaskPostRequest taskPostRequest);

    TagPutRequest getTagByTagId(int tagId);

    void postTag(TagPostRequest tagPostRequest);

    void putTag(int tagId, TagPutRequest tagPutRequest);

    void deleteTag(int tagId);

    void postMilestone(MilestonePostRequest milestonePostRequest);

    void putMilestone(int milestoneId, MilestonePutRequest milestonePutRequest);

    void deleteMilestone(int milestoneId);

    CommentPutRequest getCommentByCommentId(int commentId);

    void postComment(CommentPostRequest commentPostRequest);

    void putComment(CommentPutRequest commentPutRequest);

    void deleteComment(CommentIdOnly commentIdOnly);
}
