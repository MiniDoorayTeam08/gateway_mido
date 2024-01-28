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

import com.nhnacademy.midoo.gateway.domain.milestone.MilestoneResponse;
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
class MilestoneControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    TaskService taskService;

    @Test
    @DisplayName("마일스톤 업데이트 페이지 이동 테스트")
    void testGetMilestoneUpdateForm() throws Exception {
        when(taskService.getMilestoneByMilestoneId(anyLong())).thenReturn(new MilestoneResponse(0, null));

        mvc.perform(get("/milestones/{milestoneId}/modify", 1)
                        .sessionAttr("id", "id"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("milestone"))
                .andExpect(view().name("milestoneUpdate"));

        verify(taskService, times(1)).getMilestoneByMilestoneId(anyLong());
    }

    @Test
    @DisplayName("마일스톤 업데이트 테스트")
    void testPutMilestone() throws Exception {
        mvc.perform(post("/milestones/{milestoneId}/modify", 1)
                        .sessionAttr("id", "id")
                        .param("milestoneName", "testName"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/myprojects"));

        verify(taskService, times(1)).putMilestone(anyLong(), any());
    }

    @Test
    @DisplayName("마일스톤 삭제 테스트")
    void testDeleteMilestone() throws Exception {
        mvc.perform(post("/milestones/{milestoneId}/delete", 1)
                        .sessionAttr("id", "id"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/myprojects"));

        verify(taskService, times(1)).deleteMilestone(anyLong());
    }
}