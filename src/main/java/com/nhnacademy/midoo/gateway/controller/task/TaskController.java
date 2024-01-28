package com.nhnacademy.midoo.gateway.controller.task;

import com.nhnacademy.midoo.gateway.config.IdProperties;
import com.nhnacademy.midoo.gateway.domain.TaskDetailResponse;
import com.nhnacademy.midoo.gateway.domain.TaskPutRequest;
import com.nhnacademy.midoo.gateway.service.task.TaskService;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/{projectId}/tasks")
public class TaskController {
    private final TaskService taskService;
    private final IdProperties idProperties;

    @GetMapping("/{taskId}")
    public String getTask(@PathVariable("projectId") long projectId,
                          @PathVariable("taskId") long taskId,
                          HttpServletRequest request,
                          Model model) {
        String accountId = request.getSession().getAttribute(idProperties.getId()).toString();

        TaskDetailResponse taskDetailResponse = taskService.getTaskDetail(taskId);

        model.addAttribute("projectId", projectId);
        model.addAttribute("accountId", accountId);
        model.addAttribute("task", taskDetailResponse.getTask());
        model.addAttribute("comments", taskDetailResponse.getComments());
        model.addAttribute("tags", taskDetailResponse.getTags());
        model.addAttribute("milestone", taskDetailResponse.getTask().getMilestone());

        return "taskView";
    }

    @GetMapping("/{taskId}/modify")
    public String getTaskUpdateForm(@PathVariable("taskId") long taskId,
                                    @PathVariable("projectId") long projectId,
                                    HttpServletRequest request,
                                    Model model) {
        model.addAttribute("accountId", request.getSession().getAttribute(idProperties.getId()).toString());
        model.addAttribute("projectId", projectId);
        model.addAttribute("task", taskService.getTaskByTaskId(taskId));
        model.addAttribute("milestones", taskService.getMilestoneByProjectId(projectId));
        model.addAttribute("tags", taskService.getTagsByProjectId(projectId));

        return "/taskUpdate";
    }

    @PostMapping("/{taskId}/modify")
    public String putTask(@PathVariable("projectId") long projectId,
                          @PathVariable("taskId") long taskId,
                          @ModelAttribute TaskPutRequest taskPutRequest) {
        taskService.putTask(taskId, taskPutRequest);

        return "redirect:/" + projectId + "/tasks/" + taskId;
    }

    @PostMapping("/{taskId}/delete")
    public String deleteTask(@PathVariable("taskId") long taskId,
                             @PathVariable("projectId") long projectId) {
        taskService.deleteTask(taskId);

        return "redirect:/project/" + projectId;
    }
}
