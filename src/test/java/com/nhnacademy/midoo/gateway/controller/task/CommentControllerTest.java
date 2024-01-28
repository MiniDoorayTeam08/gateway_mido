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

import com.nhnacademy.midoo.gateway.domain.comment.CommentResponse;
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
class CommentControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    TaskService taskService;

    @Test
    @DisplayName("댓글 수정 페이지 이동 테스트")
    void testGetCommentUpdateForm() throws Exception {
        when(taskService.getCommentByCommentId(anyLong())).thenReturn(new CommentResponse());

        mvc.perform(get("/comments/{commentId}/modify", 1)
                        .sessionAttr("id", "id"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("comment"))
                .andExpect(view().name("commentUpdate"));
    }

    @Test
    @DisplayName("댓글 수정 요청 테스트")
    void testPutComment() throws Exception {
        mvc.perform(post("/comments/{commentId}/modify/{taskId}", 1, 3)
                        .sessionAttr("id", "id"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/tasks/3"));

        verify(taskService, times(1)).putComment(anyLong(), any());
    }

    @Test
    @DisplayName("댓글 삭제 테스트")
    void testDeleteComment() throws Exception {
        mvc.perform(post("/comments/delete/{taskId}", 1)
                        .sessionAttr("id", "id")
                        .param("commentId", "1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/tasks/1"));

        verify(taskService, times(1)).deleteComment(any());

    }
}