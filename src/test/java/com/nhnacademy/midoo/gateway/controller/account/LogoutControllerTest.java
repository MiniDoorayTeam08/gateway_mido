package com.nhnacademy.midoo.gateway.controller.account;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class LogoutControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("로그아웃 테스트")
    void logoutTest() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("id", "testId");
        mvc.perform(get("/logout")
                        .session(session))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/login"));
        assertTrue(session.isInvalid());
    }
}