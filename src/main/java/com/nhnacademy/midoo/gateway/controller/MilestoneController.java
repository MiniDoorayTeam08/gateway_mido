package com.nhnacademy.midoo.gateway.controller;

import com.nhnacademy.midoo.gateway.config.ServerProperties;
import com.nhnacademy.midoo.gateway.domain.MilestonePutRequest;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/milestones")
public class MilestoneController {
    private final ServerProperties serverProperties;
    private final RestTemplate restTemplate;

    public MilestoneController(ServerProperties serverProperties, RestTemplate restTemplate) {
        this.serverProperties = serverProperties;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String getMilestoneForm() {
        return "milestoneRegister";
    }

    @PostMapping
    public String postMilestone(@RequestBody MilestonePutRequest milestonePutRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = serverProperties.getTaskPort() + "/milestones/" + "${프로젝트아이디}" + "/register";

        HttpEntity<MilestonePutRequest> requestEntity = new HttpEntity<>(milestonePutRequest, httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        return "/";
    }

    @PostMapping("/{milestoneId}")
    public String putMilestone(@PathVariable("milestoneId") int milestoneId,
                               @RequestBody MilestonePutRequest milestonePutRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = serverProperties.getTaskPort() + "/milestones/" + milestoneId;

        HttpEntity<MilestonePutRequest> requestEntity = new HttpEntity<>(milestonePutRequest, httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        return "/";
    }

    @PostMapping("/{milestoneId}")
    public String deleteMilestone(@PathVariable int milestoneId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = serverProperties.getTaskPort() + "/milestones/" + milestoneId;

        HttpEntity<MilestonePutRequest> requestEntity = new HttpEntity<>(httpHeaders);
        restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });


        return "/";
    }
}