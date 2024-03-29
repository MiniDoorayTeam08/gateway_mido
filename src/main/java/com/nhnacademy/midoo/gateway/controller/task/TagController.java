package com.nhnacademy.midoo.gateway.controller.task;

import com.nhnacademy.midoo.gateway.domain.tag.TagPutRequest;
import com.nhnacademy.midoo.gateway.service.task.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tags")
public class TagController {
    private final TaskService taskService;

    public TagController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{tagId}/modify")
    public String getTagUpdateForm(@PathVariable("tagId") int tagId,
                                   Model model) {
        model.addAttribute("tag", taskService.getTagByTagId(tagId));

        return "/tagUpdate";
    }

    @PostMapping("/{tagId}/modify")
    public String putTag(@PathVariable("tagId") int tagId,
                         @ModelAttribute TagPutRequest tagPutRequest) {
        taskService.putTag(tagId, tagPutRequest);

        return "redirect:/myprojects";
    }

    @PostMapping("/{tagId}/delete")
    public String deleteTag(@PathVariable("tagId") int tagId) {
        taskService.deleteTag(tagId);

        return "redirect:/myprojects";

    }
}
