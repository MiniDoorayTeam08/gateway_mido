package com.nhnacademy.midoo.gateway.controller.task;

import com.nhnacademy.midoo.gateway.domain.milestone.MilestonePostRequest;
import com.nhnacademy.midoo.gateway.service.task.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/milestones/register")
public class MilestoneRegisterController {
    private final TaskService taskService;

    public MilestoneRegisterController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{projectId}")
    public String getMilestoneForm(@PathVariable("projectId") long projectId,
                                   Model model) {
        model.addAttribute("projectId", projectId);

        return "milestoneRegister";
    }

    @PostMapping("/{projectId}")
    public String postMilestone(@PathVariable("projectId") long projectId,
                                @ModelAttribute MilestonePostRequest milestonePostRequest) {
        taskService.postMilestone(projectId, milestonePostRequest);

        return "redirect:/project/" + projectId;
    }
}
