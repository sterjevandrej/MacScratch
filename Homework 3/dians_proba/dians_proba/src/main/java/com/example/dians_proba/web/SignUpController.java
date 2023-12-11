package com.example.dians_proba.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUpController {
    @GetMapping
    public String getSignUpPage(Model model){
        model.addAttribute("bodyContent", "signup");
        return "master_template";
    }
}
