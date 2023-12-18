package com.example.dians_proba.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/logout") //TO DO: IMPLEMENT ACTION="/logout" SOMEWHERE in HTML
public class LogoutController {
    @GetMapping
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/home";
    }
}

