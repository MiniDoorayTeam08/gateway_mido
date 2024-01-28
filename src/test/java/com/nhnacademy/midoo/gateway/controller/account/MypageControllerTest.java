package com.nhnacademy.midoo.gateway.controller.account;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
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

@SpringBootTest
@AutoConfigureMockMvc
class MypageControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private AccountService accountService;

    @Test
    @DisplayName("mypage 접근 테스트")
    void getMyPageTest() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("id", "testId");
        when(accountService.getAccountById(anyString())).thenReturn(new AccountResponse("", "", "", ""));

        mvc.perform(get("/mypage")
                        .session(session))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("accountInfo"))
                .andExpect(model().attributeExists("accountStatus"))
                .andExpect(view().name("mypage"));
    }

    @Test
    @DisplayName("userModify 테스트")
    void userModifyTest() throws Exception {
        doNothing().when(accountService).putAccount(any());

        mvc.perform(post("/mypage")
                        .param("id", "testId")
                        .param("status", "탈퇴")
                        .sessionAttr("id", "id"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/mypage"));

        verify(accountService, times(1)).putAccount(any());
    }
}