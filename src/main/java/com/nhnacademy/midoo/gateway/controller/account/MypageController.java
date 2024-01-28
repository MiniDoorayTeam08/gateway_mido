package com.nhnacademy.midoo.gateway.controller.account;


import com.nhnacademy.midoo.gateway.config.IdProperties;
import com.nhnacademy.midoo.gateway.domain.account.AccountStatus;
import com.nhnacademy.midoo.gateway.domain.account.request.AccountStatusModifyRequest;
import com.nhnacademy.midoo.gateway.service.account.AccountService;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping({"/mypage", "/"})
public class MypageController {
    private final AccountService accountService;
    private final IdProperties idProperties;

    public MypageController(AccountService accountService, IdProperties idProperties) {
        this.accountService = accountService;
        this.idProperties = idProperties;
    }

    @GetMapping
    public String getMypage(HttpServletRequest request, Model model) {
        model.addAttribute("accountInfo",
                accountService.getAccountById(
                        request.getSession(true).getAttribute(idProperties.getId()).toString()));
        model.addAttribute("accountStatus", AccountStatus.values());
        return "mypage";
    }

    @PostMapping
    public String userModify(@ModelAttribute AccountStatusModifyRequest request) {
        accountService.putAccount(request);
        return "redirect:/mypage";
    }

}
