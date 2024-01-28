package com.nhnacademy.midoo.gateway.controller.task;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.nhnacademy.midoo.gateway.domain.task.TaskDetailResponse;
import com.nhnacademy.midoo.gateway.domain.task.TaskDto;
import com.nhnacademy.midoo.gateway.service.task.TaskService;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    TaskService taskService;

    @Test
    @DisplayName("task 페이지 이동 테스트")
    void testGetTask() throws Exception {
        when(taskService.getTaskDetail(anyLong())).thenReturn(
                new TaskDetailResponse(new TaskDto(), new ArrayList<>(), new ArrayList<>()));
        mvc.perform(get("/{projectId}/tasks/{taskId}", 1, 1)
                        .sessionAttr("id", "id"))
                .andExpect(status().isOk())
                .andExpect(view().name("taskView"))
                .andExpect(model().attributeExists("projectId"))
                .andExpect(model().attributeExists("accountId"))
                .andExpect(model().attributeExists("task"))
                .andExpect(model().attributeExists("comments"))
                .andExpect(model().attributeExists("tags"));
    }

    @Test
    @DisplayName("테스크 업데이트 페이지 이동 테스트")
    void testGetTaskUpdateForm() throws Exception {
        when(taskService.getTaskByTaskId(anyLong())).thenReturn(new TaskDto());
        mvc.perform(get("/{projectId}/tasks/{taskId}/modify", 1, 1)
                        .sessionAttr("id", "id"))
                .andExpect(status().isOk())
                .andExpect(view().name("/taskUpdate"))
                .andExpect(model().attributeExists("accountId"))
                .andExpect(model().attributeExists("projectId"))
                .andExpect(model().attributeExists("task"))
                .andExpect(model().attributeExists("milestones"))
                .andExpect(model().attributeExists("tags"));
    }

    @Test
    @DisplayName("테스크 수정 테스트")
    void testPutTask() throws Exception {
        mvc.perform(post("/{projectId}/tasks/{taskId}/modify", 1, 1)
                        .sessionAttr("id", "id"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/1/tasks/1"));

        verify(taskService, times(1)).putTask(anyLong(), any());
    }

    @Test
    @DisplayName("테스크 삭제 테스트")
    void testDeleteTask() throws Exception {
        mvc.perform(post("/{projectId}/tasks/{taskId}/delete", 1, 1)
                        .sessionAttr("id", "id"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/project/1"));

        verify(taskService, times(1)).deleteTask(anyLong());
    }
}