//package com.nhnacademy.midoo.gateway.controller;
//
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.nhnacademy.midoo.gateway.domain.account.AccountDto;
//import com.nhnacademy.midoo.gateway.service.AccountService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/register")
//@RequiredArgsConstructor
//public class RegisterController {
//    @Autowired
//    private final AccountService accountService;
//
//
//    @GetMapping
//    String getRegisterForm() {
//        return "registerForm";
//    }
//
//    @PostMapping
//    public String createAccount(@RequestBody AccountDto request) throws JsonProcessingException {
//        return accountService.createAccount(request);
//    }
//
//}
