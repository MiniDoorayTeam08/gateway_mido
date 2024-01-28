package com.nhnacademy.midoo.gateway.controller.task;

import com.nhnacademy.midoo.gateway.config.IdProperties;
import com.nhnacademy.midoo.gateway.domain.task.TaskPostRequest;
import com.nhnacademy.midoo.gateway.service.task.TaskService;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tasks/register")
public class TaskRegisterController {
    private final TaskService taskService;
    private final IdProperties idProperties;

    @GetMapping("/{projectId}")
    public String getTaskRegisterForm(@PathVariable("projectId") long projectId,
                                      HttpServletRequest request,
                                      Model model) {
        model.addAttribute("accountId", request.getSession().getAttribute(idProperties.getId()));
        model.addAttribute("projectId", projectId);
        model.addAttribute("milestones", taskService.getMilestoneByProjectId(projectId));
        model.addAttribute("tags", taskService.getTagsByProjectId(projectId));

        return "taskRegister";
    }

    @PostMapping
    public String postTask(@ModelAttribute TaskPostRequest taskPostRequest) {
        taskService.postTask(taskPostRequest);

        return "redirect:/project/" + taskPostRequest.getProjectId();
    }
}