package com.nhnacademy.midoo.gateway.service.project;

import com.nhnacademy.midoo.gateway.config.task.TaskApiServerProperties;
import com.nhnacademy.midoo.gateway.domain.ProjectPostRequest;
import com.nhnacademy.midoo.gateway.domain.task.entity.ProjectDetail;
import com.nhnacademy.midoo.gateway.domain.task.entity.ProjectInfo;
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
public class ProjectServiceImpl implements ProjectService {
    private final RestTemplate template;

    private final String taskUrl;

    public ProjectServiceImpl(RestTemplate template, TaskApiServerProperties taskApiServerProperties) {
        this.template = template;
        taskUrl = taskApiServerProperties.getUrl();
    }

    public List<ProjectInfo> getProjectsByAccountId(String projectId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskUrl + "/projects/myprojects/" + projectId;

        HttpEntity<Void> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<ProjectInfo>> responseEntity = template.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getBody();
    }

    @Override
    public ProjectDetail createProject(ProjectPostRequest projectPostRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = taskUrl + "/projects/register/";

        HttpEntity<ProjectPostRequest> requestEntity = new HttpEntity<>(projectPostRequest, httpHeaders);
        ResponseEntity<ProjectDetail> responseEntity = template.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getBody();

    }

    @Override
    public ProjectDetail getProjectDetail(Long projectId) {
        return null;
    }
}
