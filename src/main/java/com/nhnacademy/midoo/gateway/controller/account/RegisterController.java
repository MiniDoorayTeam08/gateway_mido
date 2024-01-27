package com.nhnacademy.midoo.gateway.controller.account;


import com.nhnacademy.midoo.gateway.domain.account.request.AccountCreateRequest;
import com.nhnacademy.midoo.gateway.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {
    private final AccountService accountService;

    @GetMapping
    String getRegisterForm() {
        return "registerForm";
    }

    @PostMapping
    public String registerUser(@RequestParam("id") String id,
                               @RequestParam("pwd") String paaswored,
                               @RequestParam("email") String email) {
        accountService.createAccount(new AccountCreateRequest(id, paaswored, email, "활동"));

        return "redirect:/login";
    }
}
