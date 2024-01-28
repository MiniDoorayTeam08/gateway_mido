package com.nhnacademy.midoo.gateway.domain.task;

import com.nhnacademy.midoo.gateway.domain.comment.CommentResponse;
import com.nhnacademy.midoo.gateway.domain.tag.TagResponse;
import java.util.List;
import lombok.Value;

@Value
public class TaskDetailResponse {
    TaskDto task;
    List<TagResponse> tags;
    List<CommentResponse> comments;
}
