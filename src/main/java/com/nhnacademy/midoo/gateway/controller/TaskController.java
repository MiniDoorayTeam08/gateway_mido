package com.nhnacademy.midoo.gateway.controller;

import com.nhnacademy.midoo.gateway.domain.TaskPutRequest;
import com.nhnacademy.midoo.gateway.service.task.TaskService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{taskId}")
    public String getTask(@PathVariable("taskId") int taskId,
                          HttpServletRequest request,
                          Model model) {
        int accountId = Integer.parseInt(request.getSession().getAttribute("${로그인에서 사용한 이름}").toString());

        model.addAttribute("accountId", accountId);
        model.addAttribute("task", taskService.getTaskByTaskId(taskId));
        model.addAttribute("tags", taskService.getTagsByTaskId(taskId));
        model.addAttribute("milestone", taskService.getMilestoneByTaskId(taskId));
        model.addAttribute("comments", taskService.getCommentsByTaskId(taskId));

        return "taskView";
    }

    @GetMapping("/{taskId}/modify")
    public String getTaskUpdateForm(@PathVariable("taskId") int taskId,
                                    Model model) {
        model.addAttribute("task", taskService.getTaskByTaskId(taskId));

        return "/taskUpdate";
    }

    @PutMapping("/{taskId}/modify")
    public String putTask(@PathVariable("taskId") int taskId,
                          @ModelAttribute TaskPutRequest taskPutRequest) {
        taskService.putTask(taskId, taskPutRequest);

        return "redirect:/";
    }

    @DeleteMapping("{taskId}")
    public String deleteTask(@PathVariable("taskId") int taskId) {
        taskService.deleteTask(taskId);

        return "redirect:/";
    }
}
