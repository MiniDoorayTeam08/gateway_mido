package com.nhnacademy.midoo.gateway.controller.task;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
class TagRegisterControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    TaskService taskService;

    @Test
    @DisplayName("태그 등록 페이지 이동 테스트")
    void testGetTagRegisterForm() throws Exception {
        mvc.perform(get("/tags/register/{projectId}", 1)
                        .sessionAttr("id", "id"))
                .andExpect(model().attributeExists("projectId"))
                .andExpect(status().isOk())
                .andExpect(view().name("tagRegister"));
    }

    @Test
    @DisplayName("태그 등록 테스트")
    void testPostTag() throws Exception {
        mvc.perform(post("/tags/register/{projectId}", 1)
                        .sessionAttr("id", "id")
                        .param("tagName", "tagName"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/project/1"));

        verify(taskService, times(1)).postTag(anyLong(), any());
    }
}