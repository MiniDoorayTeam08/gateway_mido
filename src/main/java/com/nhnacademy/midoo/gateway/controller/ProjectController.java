package com.nhnacademy.midoo.gateway.controller;

import com.nhnacademy.midoo.gateway.domain.task.entity.ProjectDetail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {
    //    private final ProjectService projectService;
//
//    @Autowired
//    public ProjectController(ProjectService projectService) {
//        this.projectService = projectService;
//    }
    @GetMapping("/{projectId}")
    public String showProjectDetail(@PathVariable Long projectId, Model model) {
//        ProjectDetail projectDetail = projectService.getProjectDetail(projectId);
//
//        model.addAttribute("projectDetail", projectDetail);
        return "projectDetail";
    }

    @GetMapping("/create")
    public String showCreateProjectForm(Model model) {
        model.addAttribute("project", new ProjectDetail());
        return "createProject";
    }

    @PostMapping("/create")
    public String createProject(@ModelAttribute ProjectDetail projectDetail) {
//        projectService.createProject(projectDetail);
//        + projectDetail.getId();
        return "redirect:/project/";
    }

    @GetMapping("/{projectId}/edit")
    public String showEditProjectForm(@PathVariable Long projectId, Model model) {
//        ProjectDetail projectDetail = projectService.getProjectDetail(projectId);
//        model.addAttribute("project", projectDetail);
        return "editProject";
    }

    @PostMapping("/{projectId}/edit")
    public String editProject(@PathVariable Long projectId, @ModelAttribute ProjectDetail updatedProjectDetail) {

//        projectService.editProject(projectId, updatedProjectDetail);
//        + projectId;
        return "redirect:/project/";
    }
}
