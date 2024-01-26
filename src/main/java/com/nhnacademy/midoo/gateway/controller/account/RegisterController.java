package com.nhnacademy.midoo.gateway.controller.account;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.nhnacademy.midoo.gateway.service.account.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {
    @Autowired
    private final AccountServiceImpl accountServiceImpl;


    @GetMapping
    String getRegisterForm() {
        return "registerForm";
    }

    @PostMapping
    public String registerUser(@RequestParam("id") String id,
                               @RequestParam("pwd") String paaswored,
                               @RequestParam("email") String emnail) throws JsonProcessingException {


        return "redirect:/login";
    }

}
