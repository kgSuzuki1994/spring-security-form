package com.example.springsecurityform.controller;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class DemoController {
    @GetMapping(path = "login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model,
                        HttpSession session) {

        model.addAttribute("showErrorMsg", false);
        model.addAttribute("showLogoutedMsg", false);

        if (error != null) {
            if (session != null) {
                AuthenticationException ex = (AuthenticationException) session
                        .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
                if (ex != null) {
                    model.addAttribute("showErrorMsg", true);
                    model.addAttribute("errorMsg", ex.getMessage());
                }
            }
        } else if (logout != null) {
            model.addAttribute("showLogoutedMsg", true);
        }
        return "login";
    }

    @GetMapping("success")
    public String success() {
        return "success";
    }

    @GetMapping(path = "hello", produces = "text/html")
    public String hello() {
        return "Hello!";
    }

    @GetMapping(path = "page1", produces = "text/html")
    public String page1() {
        return "page1";
    }
}
