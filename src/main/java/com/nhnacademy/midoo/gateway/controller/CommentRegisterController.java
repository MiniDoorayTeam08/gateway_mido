package com.nhnacademy.midoo.gateway.controller;

import com.nhnacademy.midoo.gateway.domain.CommentPostRequest;
import com.nhnacademy.midoo.gateway.service.task.TaskService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comments/register")
public class CommentRegisterController {
    private final TaskService taskService;

    public CommentRegisterController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{taskId}")
    public String getCommentRegisterForm(@PathVariable("taskId") int taskId,
                                         HttpServletRequest request,
                                         Model model) {
        int accountId = Integer.parseInt(request.getSession().getAttribute("${로그인할 때 세션에 넣은 값}").toString());

        model.addAttribute("taskId", taskId);
        model.addAttribute("accountId", accountId);
        return "commentRegister";
    }

    @PostMapping
    public String postComment(@RequestBody CommentPostRequest commentPostRequest) {
        taskService.postComment(commentPostRequest);

        return "redirect:/";
    }
}
