package com.nhnacademy.midoo.gateway.controller.account;

import com.nhnacademy.midoo.gateway.config.IdProperties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
@RequiredArgsConstructor
public class LogoutController {
    private final IdProperties idProperties;

    @GetMapping
    public String doLogout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(idProperties.getId());
        session.invalidate();

        return "redirect:/login";
    }
}
