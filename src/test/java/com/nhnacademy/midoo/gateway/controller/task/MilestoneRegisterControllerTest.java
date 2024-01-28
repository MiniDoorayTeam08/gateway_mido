package com.nhnacademy.midoo.gateway.controller.task;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.nhnacademy.midoo.gateway.service.task.TaskService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class MilestoneRegisterControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    TaskService taskService;

    @Test
    @DisplayName("마일스톤 등록 페이지 이동 테스트")
    void testGetMilestoneForm() throws Exception {
        mvc.perform(get("/milestones/register/{projectId}", 1)
                        .sessionAttr("id", "id"))
                .andExpect(status().isOk())
                .andExpect(view().name("milestoneRegister"))
                .andExpect(model().attributeExists("projectId"));
    }

    @Test
    @DisplayName("마일스톤 등록 테스트")
    void testPostMilestone() throws Exception {
        doNothing().when(taskService).postMilestone(anyLong(), any());

        mvc.perform(post("/milestones/register/{projectId}", 1)
                        .sessionAttr("id", "id")
                        .param("milestoneName", "name"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/project/1"));
    }
}