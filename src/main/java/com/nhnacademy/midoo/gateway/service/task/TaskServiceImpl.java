package com.nhnacademy.midoo.gateway.service.task;

import com.nhnacademy.midoo.gateway.config.task.TaskApiServerProperties;
import com.nhnacademy.midoo.gateway.domain.account.AccountIdOnly;
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
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskApiServerProperties taskApiServerProperties;
    private final RestTemplate restTemplate;

    public TaskServiceImpl(TaskApiServerProperties taskApiServerProperties, RestTemplate restTemplate) {
        this.taskApiServerProperties = taskApiServerProperties;
        this.restTemplate = restTemplate;
    }

    @Override
    public TaskDto getTaskByTaskId(long taskId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/tasks/" + taskId + "/taskDto";

        HttpEntity<Void> taskRequestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<TaskDto> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                taskRequestEntity,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getBody();
    }

    @Override
    public List<TaskResponse> getTaskByProjectId(long projectId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/tasks/" + projectId;

        HttpEntity<Void> taskRequestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<TaskResponse>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                taskRequestEntity,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getBody();
    }

    @Override
    public List<MilestoneResponse> getMilestoneByProjectId(Long projectId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/milestones/" + projectId;

        HttpEntity<Void> taskRequestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<MilestoneResponse>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                taskRequestEntity,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getBody();
    }

    @Override
    public List<TagResponse> getTagByProjectId(long projectId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/tags/" + projectId;

        HttpEntity<Void> taskRequestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<TagResponse>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                taskRequestEntity,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getBody();
    }

    @Override
    public List<TagResponse> getTagsByTaskId(long taskId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/tags/" + taskId;

        HttpEntity<Void> tagRequestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<TagResponse>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                tagRequestEntity,
                new ParameterizedTypeReference<>() {
                });
        return responseEntity.getBody();
    }

    @Override
    public MilestoneResponse getMilestoneByTaskId(long taskId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/milestones/" + taskId;

        HttpEntity<MilestonePutRequest> milestoneRequestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<MilestoneResponse> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                milestoneRequestEntity,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getBody();
    }

    @Override
    public MilestoneResponse getMilestoneByMilestoneId(long milestoneId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/milestones/" + milestoneId + "/milestoneId";

        HttpEntity<Void> milestoneRequestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<MilestoneResponse> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                milestoneRequestEntity,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getBody();
    }

    @Override
    public List<CommentResponse> getCommentsByTaskId(long taskId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        String url = taskApiServerProperties.getUrl() + "/comments" + taskId;
        HttpEntity<Void> commentRequestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<CommentResponse>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                commentRequestEntity,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getBody();
    }

    @Override
    public void postTask(TaskPostRequest taskPostRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/tasks/register";

        HttpEntity<TaskPostRequest> requestEntity = new HttpEntity<>(taskPostRequest, httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public void putTask(long taskId, TaskPutRequest taskPutRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/tasks/" + taskId;

        HttpEntity<TaskPutRequest> requestEntity = new HttpEntity<>(taskPutRequest, httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public void deleteTask(long taskId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/tasks/" + taskId;

        HttpEntity<Void> requestEntity = new HttpEntity<>(httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });


    }

    @Override
    public TagResponse getTagByTagId(long tagId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/tags/" + tagId + "/tagId";

        HttpEntity<Void> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<TagResponse> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getBody();
    }

    @Override
    public List<TagResponse> getTagsByProjectId(long projectId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/tags/" + projectId;

        HttpEntity<Void> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<TagResponse>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getBody();
    }

    @Override
    public void postTag(long projectId, TagPostRequest tagPostRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/tags/" + projectId + "/register";

        HttpEntity<TagPostRequest> requestEntity = new HttpEntity<>(tagPostRequest, httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public void putTag(long tagId, TagPutRequest tagPutRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/tags/" + tagId;

        HttpEntity<TagPutRequest> requestEntity = new HttpEntity<>(tagPutRequest, httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public void deleteTag(long tagId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/tags/" + tagId;
        HttpEntity<TagPutRequest> requestEntity = new HttpEntity<>(httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public void postMilestone(long projectId, MilestonePostRequest milestonePostRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url =
                taskApiServerProperties.getUrl() + "/milestones/" + projectId + "/register";

        HttpEntity<MilestonePostRequest> requestEntity = new HttpEntity<>(milestonePostRequest, httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public void putMilestone(long milestoneId, MilestonePutRequest milestonePutRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/milestones/" + milestoneId;

        HttpEntity<MilestonePutRequest> requestEntity = new HttpEntity<>(milestonePutRequest, httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public void deleteMilestone(long milestoneId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/milestones/" + milestoneId;

        HttpEntity<MilestonePutRequest> requestEntity = new HttpEntity<>(httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public CommentResponse getCommentByCommentId(long commentId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/comments/" + commentId + "/comment";

        HttpEntity<CommentPutRequest> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<CommentResponse> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getBody();
    }

    @Override
    public void postComment(long taskId, CommentPostRequest commentPostRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/comments/" + taskId + "/register";

        HttpEntity<CommentPostRequest> requestEntity = new HttpEntity<>(commentPostRequest, httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public void putComment(long commentId, CommentPutRequest commentPutRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/comments/" + commentId;

        HttpEntity<CommentPutRequest> requestEntity = new HttpEntity<>(commentPutRequest, httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public void deleteComment(CommentIdOnly commentIdOnly) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/comments/" + commentIdOnly.getCommentId();

        HttpEntity<CommentPutRequest> requestEntity = new HttpEntity<>(httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
    }

    public List<Task> getTasksByAccountId(String accountId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/";

        HttpEntity<AccountIdOnly> requestEntity = new HttpEntity<>(new AccountIdOnly(accountId), httpHeaders);
        ResponseEntity<List<Task>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getBody();
    }

    @Override
    public TaskDetailResponse getTaskDetail(long taskId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskApiServerProperties.getUrl() + "/tasks/" + taskId + "/detail";

        HttpEntity<Void> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<TaskDetailResponse> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getBody();
    }
}