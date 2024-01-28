package com.nhnacademy.midoo.gateway.controller.account;


import com.nhnacademy.midoo.gateway.config.IdProperties;
import com.nhnacademy.midoo.gateway.domain.account.request.AccountStatusModifyRequest;
import com.nhnacademy.midoo.gateway.service.account.AccountServiceImpl;
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
    private final AccountServiceImpl accountServiceImpl;
    private final IdProperties idProperties;

    public MypageController(AccountServiceImpl accountServiceImpl, IdProperties idProperties) {
        this.accountServiceImpl = accountServiceImpl;
        this.idProperties = idProperties;
    }

    @GetMapping
    public String getMypage(HttpServletRequest request, Model model) {
        model.addAttribute("accountInfo",
                accountServiceImpl.getAccountById(
                        request.getSession(true).getAttribute(idProperties.getId()).toString()));
        return "mypage";
    }

    @PostMapping
    public String userModify(@ModelAttribute AccountStatusModifyRequest request) {
        log.info("id : {}, status : {}", request.getId(), request.getStatus());
        accountServiceImpl.putAccount(request);
        return "redirect:/mypage";
    }

}
