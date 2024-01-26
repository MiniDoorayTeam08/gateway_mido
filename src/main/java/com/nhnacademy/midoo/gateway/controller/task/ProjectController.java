package com.nhnacademy.midoo.gateway.controller.task;

import com.nhnacademy.midoo.gateway.domain.ProjectPostRequest;
import com.nhnacademy.midoo.gateway.domain.account.AccountIdNameOnly;
import com.nhnacademy.midoo.gateway.domain.task.entity.ProjectDetail;
import com.nhnacademy.midoo.gateway.service.project.ProjectService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{projectId}")
    public String showProjectDetail(@PathVariable Long projectId, Model model) {
        ProjectDetail projectDetail = projectService.getProjectDetail(projectId);

        model.addAttribute("projectDetail", projectDetail);
        return "projectDetail";
    }

    @GetMapping("/create")
    public String showCreateProjectForm(HttpServletRequest request, Model model) {
        String accountId = request.getSession().getAttribute("id").toString();

        model.addAttribute("accounts", List.of(new AccountIdNameOnly("1", "one"), new AccountIdNameOnly("2", "two"),
                new AccountIdNameOnly("3", "three")));
        model.addAttribute("accountId", accountId);
        model.addAttribute("project", new ProjectDetail());
        return "createProject";
    }

    @PostMapping("/create")
    public String createProject(@ModelAttribute ProjectPostRequest projectPostRequest) {
        projectService.createProject(projectPostRequest);

        return "redirect:/myprojects";
    }

//    @GetMapping("/{projectId}/edit")
//    public String showEditProjectForm(@PathVariable Long projectId, Model model) {
//        ProjectDetail projectDetail = projectService.getProjectDetail(projectId);
//        model.addAttribute("project", projectDetail);
//        return "editProject";
//    }

    @PostMapping("/{projectId}/edit")
    public String editProject(@PathVariable Long projectId, @ModelAttribute ProjectDetail updatedProjectDetail) {

//        projectService.editProject(projectId, updatedProjectDetail);
//        + projectId;
        return "redirect:/project/";
    }
}
