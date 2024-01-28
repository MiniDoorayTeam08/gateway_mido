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

import com.nhnacademy.midoo.gateway.domain.tag.TagResponse;
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
class TagControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    TaskService taskService;

    @Test
    @DisplayName("태그 수정 페이지 이동 테스트")
    void testGetTagUpdateForm() throws Exception {
        when(taskService.getTagByTagId(anyLong())).thenReturn(new TagResponse());
        mvc.perform(get("/tags/{tagId}/modify", 1)
                        .sessionAttr("id", "id"))
                .andExpect(model().attributeExists("tag"))
                .andExpect(status().isOk())
                .andExpect(view().name("/tagUpdate"));

        verify(taskService, times(1)).getTagByTagId(anyLong());
    }

    @Test
    @DisplayName("태그 수정 테스트")
    void testPutTag() throws Exception {
        mvc.perform(post("/tags/{tagId}/modify", 1)
                        .sessionAttr("id", "id")
                        .param("tagName", "tagName"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/myprojects"));

        verify(taskService, times(1)).putTag(anyLong(), any());
    }

    @Test
    @DisplayName("태그 삭제 테스트")
    void testDeleteTag() throws Exception {
        mvc.perform(post("/tags/{tagId}/delete", 1)
                        .sessionAttr("id", "id"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/myprojects"));

        verify(taskService, times(1)).deleteTag(anyLong());
    }
}