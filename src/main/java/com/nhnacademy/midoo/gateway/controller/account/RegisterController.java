package com.nhnacademy.midoo.gateway.controller.account;


import com.nhnacademy.midoo.gateway.domain.account.request.AccountCreateRequest;
import com.nhnacademy.midoo.gateway.service.account.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final AccountService accountService;

    public RegisterController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String getRegisterForm() {
        return "registerForm";
    }

    @PostMapping
    public String registerAccount(@RequestParam("id") String id,
                                  @RequestParam("password") String password,
                                  @RequestParam("email") String email) {
        accountService.createAccount(new AccountCreateRequest(id, password, email, "활동"));

        return "redirect:/login";
    }
}
