package com.nhnacademy.midoo.gateway.controller;

import com.nhnacademy.midoo.gateway.domain.MilestonePutRequest;
import com.nhnacademy.midoo.gateway.service.task.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/milestones")
public class MilestoneController {
    private final TaskService taskService;

    public MilestoneController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/{milestoneId}/modify")
    public String putMilestone(@PathVariable("milestoneId") int milestoneId,
                               @ModelAttribute MilestonePutRequest milestonePutRequest) {
        taskService.putMilestone(milestoneId, milestonePutRequest);

        return "redirect:/";
    }

    @PostMapping("/{milestoneId}")
    public String deleteMilestone(@PathVariable int milestoneId) {
        taskService.deleteMilestone(milestoneId);


        return "redirect:/";
    }
}