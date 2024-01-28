package com.nhnacademy.midoo.gateway.domain;

import com.nhnacademy.midoo.gateway.domain.response.CommentResponse;
import com.nhnacademy.midoo.gateway.domain.response.TagResponse;
import java.util.List;
import lombok.Value;

@Value
public class TaskDetailResponse {
    TaskDto task;
    List<TagResponse> tags;
    List<CommentResponse> comments;
}
