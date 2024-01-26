package com.nhnacademy.midoo.gateway.controller;


import com.nhnacademy.midoo.gateway.domain.account.AccountUpdateDto;
import com.nhnacademy.midoo.gateway.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {
    private final AccountService accountService;

    @Autowired
    public MypageController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountId}")
    public String getMypage(@PathVariable String accountId, Model model) {
////        AccountInfo accountInfo = accountService.getAccountInfoById(accountId);
//        model.addAttribute("accountInfo", accountInfo);
        return "mypage";
    }

    @PostMapping
    public String userModify(@RequestBody AccountUpdateDto accountUpdateDto) {
//        accountService.putAccount(new AccountDto(),accountUpdateDto.getId());
        return "mypage";
    }

}
