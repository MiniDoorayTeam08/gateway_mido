package com.nhnacademy.midoo.gateway.controller.account;

import com.nhnacademy.midoo.gateway.domain.account.request.LoginRequest;
import com.nhnacademy.midoo.gateway.domain.account.response.AccountResponse;
import com.nhnacademy.midoo.gateway.service.account.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    @Autowired
    private final AccountServiceImpl accountServiceImpl;


    @GetMapping
    String getLoginForm() {
        return "loginForm";
    }

    @PostMapping
    public String postLogin(@RequestParam("id") String id,
                            @RequestParam("pwd") String paaswored, Model model) {
        AccountResponse response = accountServiceImpl.matchIdPwd(new LoginRequest(id, paaswored));
        model.addAttribute("account", response);
        return "mypage/" + response.getId();

    }
}
