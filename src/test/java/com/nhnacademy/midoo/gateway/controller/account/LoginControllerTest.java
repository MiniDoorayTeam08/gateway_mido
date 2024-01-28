package com.nhnacademy.midoo.gateway.controller.account;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.nhnacademy.midoo.gateway.domain.account.response.AccountResponse;
import com.nhnacademy.midoo.gateway.service.account.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class LoginControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private AccountService accountService;

    @Test
    @DisplayName("로그인 폼으로 이동 테스트")
    void getLoginFormTest() throws Exception {
        mvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("loginForm"));
    }

    @Test
    @DisplayName("로그인 한 상태에서 로그인 폼으로 이동 테스트 : mypage로 이동")
    void getLoginFormTestWhenLoggedIn() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("id", "testId");
        mvc.perform(get("/login")
                        .session(session))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/mypage"))
                .andReturn();
    }

    @Test
    @DisplayName("로그인 테스트")
    void doLogin() throws Exception {
        when(accountService.matchIdPwd(any())).thenReturn(true);
        when(accountService.getAccountById(anyString())).thenReturn(new AccountResponse("id", " ", " ", " "));

        mvc.perform(post("/login")
                        .session(new MockHttpSession())
                        .param("id", "id")
                        .param("password", "password"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/mypage"));
    }

    @Test
    @DisplayName("로그인 실패 테스트")
    void doLoginFailTest() throws Exception {
        when(accountService.matchIdPwd(any())).thenReturn(false);
        mvc.perform(post("/login")
                        .session(new MockHttpSession()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/login"));
    }

}