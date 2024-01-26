package com.nhnacademy.midoo.gateway.controller;

import com.nhnacademy.midoo.gateway.config.ServerProperties;
import com.nhnacademy.midoo.gateway.domain.TagPutRequest;
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
@RequestMapping("/tags")
public class TagController {
    private final ServerProperties serverProperties;
    private final RestTemplate restTemplate;

    public TagController(ServerProperties serverProperties, RestTemplate restTemplate) {
        this.serverProperties = serverProperties;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String getTagRegisterForm() {
        return "tagRegister";
    }

    @GetMapping("/{tagId}/modify")
    public String getTagUpdateForm(@PathVariable("tagId") int tagId,
                                   Model model) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = serverProperties.getTaskPort() + "/tags/" + tagId;

        HttpEntity<TagPutRequest> requestEntity = new HttpEntity<>(httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        model.addAttribute("tag", requestEntity.getBody());

        return "/tagUpdate";
    }

    @PostMapping
    public String postTag(@RequestBody TagPutRequest tagPutRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = serverProperties.getTaskPort() + "/tags/" + "${프로젝트아이디}" + "register";

        HttpEntity<TagPutRequest> requestEntity = new HttpEntity<>(tagPutRequest, httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        return "/";
    }

    @PostMapping
    public String putTag(@RequestBody TagPutRequest tagPutRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = serverProperties.getTaskPort() + "/tags/" + tagPutRequest.getTagId();

        HttpEntity<TagPutRequest> requestEntity = new HttpEntity<>(tagPutRequest, httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        return "/";
    }

    @PostMapping("/{tagId}")
    public String deleteTag(@PathVariable("tagId") int tagId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = serverProperties.getTaskPort() + "/tags/" + tagId;
        HttpEntity<TagPutRequest> requestEntity = new HttpEntity<>(httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        return "/";
    }
}
