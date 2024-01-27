package com.nhnacademy.midoo.gateway.controller.account;

import com.nhnacademy.midoo.gateway.domain.task.entity.ProjectInfo;
import com.nhnacademy.midoo.gateway.service.project.ProjectService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myprojects")
public class MyProjectController {

    private final ProjectService projectService;

    public MyProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String showMyProjects(HttpServletRequest request, Model model) {
        String accountId = request.getSession().getAttribute("id").toString();

        List<ProjectInfo> projects = projectService.getProjectsByAccountId(accountId);

        model.addAttribute("projects", projects);
        return "myProject";
    }
}
