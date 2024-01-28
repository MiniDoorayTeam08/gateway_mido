package com.nhnacademy.midoo.gateway.controller.task;

import com.nhnacademy.midoo.gateway.domain.comment.CommentIdOnly;
import com.nhnacademy.midoo.gateway.domain.comment.CommentPutRequest;
import com.nhnacademy.midoo.gateway.service.task.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comments")
public class CommentController {
    private final TaskService taskService;

    public CommentController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("{commentId}/modify")
    public String getCommentUpdateForm(@PathVariable("commentId") long commentId,
                                       Model model) {
        model.addAttribute("comment", taskService.getCommentByCommentId(commentId));

        return "commentUpdate";
    }

    @PostMapping("/{commentId}/modify/{taskId}")
    public String putComment(@PathVariable("commentId") long commentId,
                             @PathVariable("taskId") long taskId,
                             @ModelAttribute CommentPutRequest commentPutRequest) {
        taskService.putComment(commentId, commentPutRequest);

        return "redirect:/tasks/" + taskId;
    }

    @PostMapping("/delete/{taskId}")
    public String deleteComment(@PathVariable("taskId") long taskId,
                                @ModelAttribute CommentIdOnly commentIdOnly) {
        taskService.deleteComment(commentIdOnly);

        return "redirect:/tasks/" + taskId;

    }
}