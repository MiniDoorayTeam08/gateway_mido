package com.nhnacademy.midoo.gateway.controller.task;

import com.nhnacademy.midoo.gateway.service.task.TaskService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mytask")
public class MyTaskController {
    private final TaskService taskService;

    public MyTaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getMyTaskPage(HttpServletRequest request,
                                Model model) {
        String accountId = request.getSession().getAttribute("${로그인에서 세션에 넣은 값}").toString();

        model.addAttribute("tasks", taskService.getTasksByAccountId(accountId));

        return "/myTaskPage";
    }
}