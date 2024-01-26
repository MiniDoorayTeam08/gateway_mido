package com.nhnacademy.midoo.gateway.controller;

import com.nhnacademy.midoo.gateway.config.ServerProperties;
import com.nhnacademy.midoo.gateway.domain.All;
import com.nhnacademy.midoo.gateway.domain.CommentPutRequest;
import com.nhnacademy.midoo.gateway.domain.TagPutRequest;
import com.nhnacademy.midoo.gateway.domain.TaskPutRequest;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final ServerProperties serverProperties;
    private final RestTemplate restTemplate;

    public TaskController(ServerProperties serverProperties, RestTemplate restTemplate) {
        this.serverProperties = serverProperties;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{taskId}")
    public String getTask(@PathVariable("taskId") int taskId,
                          Model model) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = serverProperties.getTaskPort() + "/tasks/" + taskId;

        HttpEntity<TaskPutRequest> taskRequestEntity = new HttpEntity<>(httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.GET,
                taskRequestEntity,
                new ParameterizedTypeReference<>() {
                });

        url = serverProperties.getTaskPort() + "/tags/" + taskId;
        HttpEntity<List<TagPutRequest>> tagRequestEntity = new HttpEntity<>(httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.GET,
                tagRequestEntity,
                new ParameterizedTypeReference<>() {
                });

        url = serverProperties.getTaskPort() + "/milestones/" + taskId;
        HttpEntity<List<TagPutRequest>> milestoneRequestEntity = new HttpEntity<>(httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.GET,
                milestoneRequestEntity,
                new ParameterizedTypeReference<>() {
                });

        url = serverProperties.getTaskPort() + "/comments" + +taskId;
        HttpEntity<List<CommentPutRequest>> commentRequestEntity = new HttpEntity<>(httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.GET,
                commentRequestEntity,
                new ParameterizedTypeReference<>() {
                });


        model.addAttribute("tasks", taskRequestEntity.getBody());
        model.addAttribute("tags", tagRequestEntity.getBody());
        model.addAttribute("milestone", milestoneRequestEntity.getBody());
        model.addAttribute("comments", commentRequestEntity.getBody());


        return "taskView";
    }

    @GetMapping("/{taskId}/modify")
    public String getTaskUpdateForm(@PathVariable("taskId") int taskId,
                                    Model model) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = serverProperties.getTaskPort() + "/tasks/" + taskId;

        HttpEntity<TaskPutRequest> requestEntity = new HttpEntity<>(httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        model.addAttribute("task", requestEntity.getBody());

        return "/taskRegister";
    }

    @PutMapping("/{taskId}/modify")
    public String putTask(@PathVariable("taskId") int taskId,
                          @RequestBody TaskPutRequest taskPutRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = serverProperties.getTaskPort() + "/tasks/" + taskId;

        HttpEntity<TaskPutRequest> requestEntity = new HttpEntity<>(taskPutRequest, httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        return "/";
    }

    @DeleteMapping("{taskId}")
    public String deleteTask(@PathVariable("taskId") int taskId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = serverProperties.getTaskPort() + "/tasks/" + taskId;

        HttpEntity<List<All>> requestEntity = new HttpEntity<>(httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        return "/";
    }
}
