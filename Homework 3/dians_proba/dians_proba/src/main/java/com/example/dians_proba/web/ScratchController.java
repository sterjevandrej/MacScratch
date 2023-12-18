package com.example.dians_proba.web;

import com.example.dians_proba.service.MonumentService;
import com.example.dians_proba.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/scratch")
public class ScratchController {
    private final MonumentService monumentService;
    private final UserService userService;

    public ScratchController(MonumentService monumentService, UserService userService) {
        this.monumentService = monumentService;
        this.userService = userService;
    }

    @GetMapping
    public String listPlaces(Model model){
        model.addAttribute("monuments", monumentService.listAllMonumentsSine());
        model.addAttribute("bodyContent", "scratch");
        return "master_template";
    }

    @PostMapping("/wishlist/{name}")
    public String addToWishList(@PathVariable String name, Model model) {
        userService.addWishList("anabanana", name);
        return "redirect:/scratch";
    }
    @PostMapping("/visited/{name}")
    public String addToVisited(@PathVariable String name, Model model) {
        userService.addToVisited("anabanana", name);
        return "redirect:/scratch";
    }
    @PostMapping("/favorites/{name}")
    public String addToFavorites(@PathVariable String name, Model model) {
        userService.addToFavorites("anabanana", name);
        return "redirect:/scratch";
    }
}
