package com.nhnacademy.midoo.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myproject")
public class MyProjectController {

//    private final ProjectService projectService;
//
//    @Autowired
//    public MyProjectController(ProjectService projectService) {
//        this.projectService = projectService;
//    }

    @GetMapping("/{accountId}")
    public String showMyProjects(@PathVariable Long accountId, Model model) {
//        List<ProjectInfo> projects = projectService.getProjectsByAccountId(accountId); //pagenation?

//        model.addAttribute("projects", projects);
        return "myProject";
    }

}
