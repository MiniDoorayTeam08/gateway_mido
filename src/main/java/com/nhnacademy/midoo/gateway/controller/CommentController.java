package com.nhnacademy.midoo.gateway.controller;

import com.nhnacademy.midoo.gateway.config.ServerProperties;
import com.nhnacademy.midoo.gateway.domain.CommentIdOnly;
import com.nhnacademy.midoo.gateway.domain.CommentPostRequest;
import com.nhnacademy.midoo.gateway.domain.CommentPutRequest;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/comments")
public class CommentController {
    private final ServerProperties serverProperties;
    private final RestTemplate restTemplate;

    public CommentController(ServerProperties serverProperties, RestTemplate restTemplate) {
        this.serverProperties = serverProperties;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/register")
    public String getCommentRegisterForm() {
        return "commentRegister";
    }

    @GetMapping("{commentId}/modify")
    public String getCommentUpdateForm(@PathVariable("commentId") int id,
                                       Model model) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = serverProperties.getTaskPort() + "/comments/" + id;

        HttpEntity<CommentPutRequest> requestEntity = new HttpEntity<>(httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        model.addAttribute("comment", requestEntity.getBody());

        return "commentUpdate";
    }

    @PostMapping("/register")
    public String postComment(@RequestBody CommentPostRequest commentPostRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = serverProperties.getTaskPort() + "/comments/" + commentPostRequest.getTaskId() + "/register";

        HttpEntity<CommentPostRequest> requestEntity = new HttpEntity<>(commentPostRequest, httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        return "/";
    }

    @PostMapping("/modify")
    public String putComment(@RequestBody CommentPutRequest commentPutRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = serverProperties.getTaskPort() + "/comments/" + commentPutRequest.getCommentId() + "/modify";

        HttpEntity<CommentPutRequest> requestEntity = new HttpEntity<>(commentPutRequest, httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        return "/";
    }

    @PostMapping("/delete")
    public String deleteComment(@RequestBody CommentIdOnly commentIdOnly) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = serverProperties.getTaskPort() + "/comments/" + commentIdOnly.getCommentId();

        HttpEntity<CommentPutRequest> requestEntity = new HttpEntity<>(httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        return "/";
    }
}