package com.nhnacademy.midoo.gateway.controller.task;

import com.nhnacademy.midoo.gateway.domain.TaskPostRequest;
import com.nhnacademy.midoo.gateway.service.task.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks/register")
public class TaskRegisterController {
    private final TaskService taskService;

    public TaskRegisterController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{projectId}")
    public String getTaskRegisterForm(@PathVariable("projectId") int projectId,
                                      Model model) {
        model.addAttribute("projectId", projectId);

        return "taskRegister";
    }

    @PostMapping
    public String postTask(@ModelAttribute TaskPostRequest taskPostRequest) {
        taskService.postTask(taskPostRequest);

        return "redirect:/";
    }
}