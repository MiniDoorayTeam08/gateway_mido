package com.nhnacademy.midoo.gateway.controller;

import com.nhnacademy.midoo.gateway.domain.TaskPostRequest;
import com.nhnacademy.midoo.gateway.service.task.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks/register")
public class TaskRegisterController {
    private final TaskService taskService;

    public TaskRegisterController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTaskRegisterForm() {
        return "taskRegister";
    }

    @PostMapping
    public String postTask(@RequestBody TaskPostRequest taskPostRequest) {
        taskService.postTask(taskPostRequest);

        return "/";
    }
}