package com.nhnacademy.midoo.gateway.controller.account;

import com.nhnacademy.midoo.gateway.domain.account.request.LoginRequest;
import com.nhnacademy.midoo.gateway.domain.account.response.AccountResponse;
import com.nhnacademy.midoo.gateway.service.account.AccountServiceImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private final AccountServiceImpl accountServiceImpl;


    @GetMapping
    String getLoginForm() {
        return "loginForm";
    }

    @PostMapping
    public String postLogin(@ModelAttribute LoginRequest loginRequest,
                            HttpServletRequest request,
                            Model model) {
        AccountResponse response = accountServiceImpl.matchIdPwd(loginRequest);
        HttpSession session = request.getSession(true);
        session.setAttribute("id", response.getId());

        model.addAttribute("account", response);

        return "redirect:/mypage/" + response.getId();

    }
}
