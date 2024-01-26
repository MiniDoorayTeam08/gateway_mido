package com.nhnacademy.midoo.gateway.controller;

import com.nhnacademy.midoo.gateway.config.ServerProperties;
import com.nhnacademy.midoo.gateway.domain.AccountIdOnly;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

//option+command+v : 리턴타입 자동으로 만들어줌
@Controller
@RequestMapping("/mytask")
public class MyTaskController {
    private final ServerProperties serverProperties;
    private final RestTemplate restTemplate;

    public MyTaskController(ServerProperties serverProperties, RestTemplate restTemplate) {
        this.serverProperties = serverProperties;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String getMyTaskPage(HttpServletRequest request,
                                Model model) {
        int accountId = Integer.parseInt(request.getSession().getAttribute("${로그인에서 세션에 넣은 값}").toString());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = serverProperties.getTaskPort() + "/";

        HttpEntity<AccountIdOnly> requestEntity = new HttpEntity<>(new AccountIdOnly(accountId), httpHeaders);
        ResponseEntity<List<Task>> exchange = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        model.addAttribute("tasks", exchange.getBody());

        return "/myTaskPage";
    }
}