package com.nhnacademy.midoo.gateway.controller.account;

import com.nhnacademy.midoo.gateway.config.IdProperties;
import com.nhnacademy.midoo.gateway.domain.account.request.LoginRequest;
import com.nhnacademy.midoo.gateway.domain.account.response.AccountResponse;
import com.nhnacademy.midoo.gateway.service.account.AccountService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final AccountService accountService;
    private final IdProperties idProperties;

    @GetMapping
    public String getLoginForm(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute(idProperties.getId()) != null) {
            return "redirect:/mypage";
        }
        return "loginForm";
    }

    @PostMapping
    public String postLogin(@ModelAttribute LoginRequest loginRequest,
                            HttpServletRequest request,
                            Model model) {
        if (!accountService.matchIdPwd(loginRequest)) {
            return "redirect:/login";
        }

        AccountResponse response = accountService.getAccountById(loginRequest.getId());

        HttpSession session = request.getSession(true);
        session.setAttribute("id", response.getId());

        model.addAttribute("account", response);

        return "redirect:/mypage";
    }
}
