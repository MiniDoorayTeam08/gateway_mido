package com.nhnacademy.midoo.gateway.controller.account;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.nhnacademy.midoo.gateway.config.IdProperties;
import com.nhnacademy.midoo.gateway.service.task.ProjectService;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class MyProjectControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    ProjectService projectService;

    @Autowired
    IdProperties idProperties;

    @Test
    void showMyProjectsTest() throws Exception {
        when(projectService.getProjectsByAccountId(anyString())).thenReturn(new ArrayList<>());

        mvc.perform(get("/myprojects")
                        .sessionAttr("id", "id"))
                .andExpect(status().isOk())
                .andExpect(view().name("myProject"))
                .andExpect(model().attributeExists("projects"));
    }
}