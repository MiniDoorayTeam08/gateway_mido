package com.nhnacademy.midoo.gateway.controller.task;

import com.nhnacademy.midoo.gateway.config.IdProperties;
import com.nhnacademy.midoo.gateway.domain.milestone.MilestoneResponse;
import com.nhnacademy.midoo.gateway.domain.project.ProjectDetail;
import com.nhnacademy.midoo.gateway.domain.project.ProjectPostRequest;
import com.nhnacademy.midoo.gateway.domain.project.ProjectResponse;
import com.nhnacademy.midoo.gateway.domain.tag.TagResponse;
import com.nhnacademy.midoo.gateway.domain.task.TaskResponse;
import com.nhnacademy.midoo.gateway.service.account.AccountService;
import com.nhnacademy.midoo.gateway.service.task.ProjectService;
import com.nhnacademy.midoo.gateway.service.task.TaskService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    private final AccountService accountService;
    private final TaskService taskService;
    private final IdProperties idProperties;
    
    @GetMapping("/{projectId}")
    public String showProjectDetail(@PathVariable Long projectId, Model model) {
        ProjectResponse projectResponse = projectService.getProjectDetail(projectId);
        List<TaskResponse> tasks = taskService.getTaskByProjectId(projectId);
        List<MilestoneResponse> milestones = taskService.getMilestoneByProjectId(projectId);
        List<TagResponse> tags = taskService.getTagByProjectId(projectId);

        model.addAttribute("project", projectResponse);
        model.addAttribute("tasks", tasks);
        model.addAttribute("milestones", milestones);
        model.addAttribute("tags", tags);

        return "projectDetail";
    }

    @GetMapping("/create")
    public String showCreateProjectForm(HttpServletRequest request, Model model) {
        String accountId = request.getSession().getAttribute(idProperties.getId()).toString();

        model.addAttribute("accounts", accountService.getAccountsAll());
        model.addAttribute("accountId", accountId);
        model.addAttribute("project", new ProjectDetail());
        return "createProject";
    }

    @PostMapping("/create")
    public String createProject(@ModelAttribute ProjectPostRequest projectPostRequest) {
        projectService.createProject(projectPostRequest);

        return "redirect:/myprojects";
    }
}
