package com.nhnacademy.midoo.gateway.controller.account;


import com.nhnacademy.midoo.gateway.domain.account.request.AccountStatusModifyRequest;
import com.nhnacademy.midoo.gateway.service.account.AccountServiceImpl;
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
    private final AccountServiceImpl accountServiceImpl;

    @Autowired
    public MypageController(AccountServiceImpl accountServiceImpl) {
        this.accountServiceImpl = accountServiceImpl;
    }

    @GetMapping("/{accountId}")
    public String getMypage(@PathVariable String accountId, Model model) {
        model.addAttribute("accountInfo", accountServiceImpl.getAccountById(accountId));
        return "mypage";
    }

    @PostMapping
    public String userModify(@RequestBody AccountStatusModifyRequest request) {
        accountServiceImpl.putAccount(request.getId(), request);
        return "mypage" + request.getId();
    }

}
