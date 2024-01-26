package com.nhnacademy.midoo.gateway.controller;

import com.nhnacademy.midoo.gateway.domain.MilestonePostRequest;
import com.nhnacademy.midoo.gateway.service.task.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/milestone/register")
public class MilestoneRegisterController {
    private final TaskService taskService;

    public MilestoneRegisterController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{projectId}")
    public String getMilestoneForm(@PathVariable("projectId") int projectId,
                                   Model model) {
        model.addAttribute("projectId", projectId);

        return "milestoneRegister";
    }

    @PostMapping
    public String postMilestone(@ModelAttribute MilestonePostRequest milestonePostRequest) {
        taskService.postMilestone(milestonePostRequest);

        return "redirect:/";
    }
}
