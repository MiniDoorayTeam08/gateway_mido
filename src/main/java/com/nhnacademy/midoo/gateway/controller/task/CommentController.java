package com.nhnacademy.midoo.gateway.controller.task;

import com.nhnacademy.midoo.gateway.domain.CommentIdOnly;
import com.nhnacademy.midoo.gateway.domain.CommentPostRequest;
import com.nhnacademy.midoo.gateway.domain.CommentPutRequest;
import com.nhnacademy.midoo.gateway.service.task.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comments")
public class CommentController {
    private final TaskService taskService;

    public CommentController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/register")
    public String getCommentRegisterForm() {
        return "commentRegister";
    }

    @GetMapping("{commentId}/modify")
    public String getCommentUpdateForm(@PathVariable("commentId") int commentId,
                                       Model model) {
        model.addAttribute(taskService.getCommentByCommentId(commentId));

        return "commentUpdate";
    }

    @PostMapping("/register")
    public String postComment(@RequestBody CommentPostRequest commentPostRequest) {
        taskService.postComment(commentPostRequest);

        return "/";
    }

    @PostMapping("/modify")
    public String putComment(@RequestBody CommentPutRequest commentPutRequest) {
        taskService.putComment(commentPutRequest);

        return "/";
    }

    @PostMapping("/delete")
    public String deleteComment(@RequestBody CommentIdOnly commentIdOnly) {
        taskService.deleteComment(commentIdOnly);

        return "/";
    }
}