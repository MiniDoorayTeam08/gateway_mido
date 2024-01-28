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

import com.nhnacademy.midoo.gateway.config.IdProperties;
import com.nhnacademy.midoo.gateway.domain.project.ProjectResponse;
import com.nhnacademy.midoo.gateway.service.account.AccountService;
import com.nhnacademy.midoo.gateway.service.task.ProjectService;
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
public class ProjectControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    ProjectService projectService;

    @MockBean
    TaskService taskService;

    @MockBean
    AccountService accountService;

    @MockBean
    IdProperties idProperties;

    @Test
    @DisplayName("프로젝트 상세 정보 페이지 테스트")
    void testShowProjectDetail() throws Exception {
        when(projectService.getProjectDetail(anyLong())).thenReturn(new ProjectResponse());
        mvc.perform(get("/project/{projectId}", 1)
                        .sessionAttr("id", "id"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("project"))
                .andExpect(model().attributeExists("tasks"))
                .andExpect(model().attributeExists("milestones"))
                .andExpect(model().attributeExists("tags"))
                .andExpect(view().name("projectDetail"));

        verify(projectService, times(1)).getProjectDetail(anyLong());
        verify(taskService, times(1)).getTaskByProjectId(anyLong());
        verify(taskService, times(1)).getMilestoneByProjectId(anyLong());
        verify(taskService, times(1)).getTagByProjectId(anyLong());
    }

    @Test
    @DisplayName("프로젝트 생성 페이지 이동 테스트")
    void testShowCreateProjectForm() throws Exception {
        when(idProperties.getId()).thenReturn("id");
        mvc.perform(get("/project/create")
                        .sessionAttr("id", "id"))
                .andExpect(status().isOk())
                .andExpect(view().name("createProject"))
                .andExpect(model().attributeExists("accounts"))
                .andExpect(model().attributeExists("accountId"))
                .andExpect(model().attributeExists("project"));
    }

    @Test
    @DisplayName("프로젝트 생성 테스트")
    void testCreateProject() throws Exception {
        mvc.perform(post("/project/create")
                        .sessionAttr("id", "id")
                        .param("accountId", "accountId")
                        .param("projectName", "testName")
                        .param("projectStatus", "생성")
                        .param("projectExplain", "expalin")
                        .param("projectMemberIdList", "null"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/myprojects"));

        verify(projectService, times(1)).createProject(any());
    }

}
