package com.nhnacademy.midoo.gateway.controller.account;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.nhnacademy.midoo.gateway.service.account.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class RegisterControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    AccountService accountService;

    @Test
    @DisplayName("registerForm 페이지 이동 테스트")
    void testGetRegisterForm() throws Exception {
        mvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("registerForm"));
    }

    @Test
    @DisplayName("Account 등록 테스트")
    void testRegisterUser() throws Exception {
        when(accountService.createAccount(any())).thenReturn(null);

        mvc.perform(post("/register")
                        .param("id", "id")
                        .param("password", "password")
                        .param("email", "email"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
    }
}