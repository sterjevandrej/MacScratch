package com.example.dians_proba.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class AssistantController {

//    private final

    @GetMapping("/wishlist")
    public String wishlist(Model model){
        model.addAttribute("bodyContent", "wishlist");
        return "master_template";
    }

    @GetMapping("/visited")
    public String visited(Model model){
        model.addAttribute("bodyContent", "visited");
        return "master_template";
    }

    @GetMapping("/favourites")
    public String favourites(Model model){
        model.addAttribute("bodyContent", "favourites");
        return "master_template";
    }
}
