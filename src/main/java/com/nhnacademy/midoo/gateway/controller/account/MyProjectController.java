package com.nhnacademy.midoo.gateway.controller.account;

import com.nhnacademy.midoo.gateway.config.IdProperties;
import com.nhnacademy.midoo.gateway.domain.project.ProjectInfo;
import com.nhnacademy.midoo.gateway.service.task.ProjectService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myprojects")
@RequiredArgsConstructor
public class MyProjectController {
    private final ProjectService projectService;
    private final IdProperties idProperties;

    @GetMapping
    public String showMyProjects(HttpServletRequest request, Model model) {
        String accountId = request.getSession().getAttribute(idProperties.getId()).toString();

        List<ProjectInfo> projects = projectService.getProjectsByAccountId(accountId);

        model.addAttribute("projects", projects);
        return "myProject";
    }
}
