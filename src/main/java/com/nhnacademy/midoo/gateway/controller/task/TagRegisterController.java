package com.nhnacademy.midoo.gateway.controller.task;

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

    @PostMapping("/{projectId}")
    public String postTag(@PathVariable("projectId") long projectId, @ModelAttribute TagPostRequest tagPostRequest) {
        taskService.postTag(projectId, tagPostRequest);

        return "redirect:/project/" + projectId;
    }
}
