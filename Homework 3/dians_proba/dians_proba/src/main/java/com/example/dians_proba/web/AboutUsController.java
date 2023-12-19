package com.example.dians_proba.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about-us")
public class AboutUsController {
    @GetMapping
    public String getAboutUsPage(Model model) {
        model.addAttribute("bodyContent", "about");
        return "master_template";
    }
}
