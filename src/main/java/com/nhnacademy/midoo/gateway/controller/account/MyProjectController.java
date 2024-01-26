package com.nhnacademy.midoo.gateway.controller.account;

import com.nhnacademy.midoo.gateway.domain.task.entity.ProjectInfo;
import com.nhnacademy.midoo.gateway.service.project.ProjectService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myprojects")
public class MyProjectController {

    private final ProjectService projectService;

    public MyProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{accountId}")
    public String showMyProjects(@PathVariable String accountId, HttpServletRequest request, Model model) {
        if (!accountId.equals(request.getSession(true).getAttribute("id").toString())) {
            throw new RuntimeException(); // 잘못된 요청 에러 던지기
        }

        List<ProjectInfo> projects = projectService.getProjectsByAccountId(accountId); //pagenation?

        model.addAttribute("projects", projects);
        return "myProject";
    }
}
