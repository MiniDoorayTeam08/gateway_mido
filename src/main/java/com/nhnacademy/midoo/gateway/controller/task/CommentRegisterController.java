package com.nhnacademy.midoo.gateway.controller.task;

import com.nhnacademy.midoo.gateway.domain.comment.CommentPostRequest;
import com.nhnacademy.midoo.gateway.service.task.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comments/register")
public class CommentRegisterController {
    private final TaskService taskService;

    public CommentRegisterController(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @PostMapping("/{taskId}")
    public String postComment(@PathVariable("taskId") long taskId,
                              @ModelAttribute CommentPostRequest commentPostRequest) {
        taskService.postComment(taskId, commentPostRequest);

        return "redirect:/tasks/" + taskId;
    }
}
