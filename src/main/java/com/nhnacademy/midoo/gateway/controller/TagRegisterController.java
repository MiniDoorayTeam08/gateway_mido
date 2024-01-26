package com.nhnacademy.midoo.gateway.controller;

import com.nhnacademy.midoo.gateway.domain.TagPostRequest;
import com.nhnacademy.midoo.gateway.service.task.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tags/register")
public class TagRegisterController {
    private final TaskService taskService;

    public TagRegisterController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{projectId}")
    public String getTagRegisterForm(@PathVariable("projectId") int projectId,
                                     Model model) {
        model.addAttribute("projectId", projectId);

        return "tagRegister";
    }

    @PostMapping
    public String postTag(@ModelAttribute TagPostRequest tagPostRequest) {
        taskService.postTag(tagPostRequest);

        return "redirect:/";
    }
}
