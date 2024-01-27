package com.nhnacademy.midoo.gateway.controller.task;

import com.nhnacademy.midoo.gateway.domain.MilestonePutRequest;
import com.nhnacademy.midoo.gateway.service.task.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/{milestoneId}/modify")
    public String getMilestoneUpdateForm(@PathVariable("milestoneId") long milestoneId,
                                         Model model) {
        model.addAttribute("milestone", taskService.getMilestoneByMilestoneId(milestoneId));

        return "milestoneUpdate";
    }

    @PostMapping("/{milestoneId}/modify")
    public String putMilestone(@PathVariable("milestoneId") int milestoneId,
                               @ModelAttribute MilestonePutRequest milestonePutRequest) {
        taskService.putMilestone(milestoneId, milestonePutRequest);

        return "redirect:/myprojects";

    }

    @PostMapping("/{milestoneId}")
    public String deleteMilestone(@PathVariable int milestoneId) {
        taskService.deleteMilestone(milestoneId);

        return "redirect:/";

    }
}