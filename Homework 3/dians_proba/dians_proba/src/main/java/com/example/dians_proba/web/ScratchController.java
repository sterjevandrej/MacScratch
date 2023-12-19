package com.example.dians_proba.web;

import com.example.dians_proba.model.User;
import com.example.dians_proba.model.exceptions.NotLoggedInException;
import com.example.dians_proba.service.MonumentService;
import com.example.dians_proba.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
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
    public String listPlaces(Model model) {
        model.addAttribute("monuments", monumentService.listAllMonumentsSine());
        model.addAttribute("bodyContent", "scratch");
        return "master_template";
    }

    @PostMapping("/wishlist/{name}")
    public String addToWishList(@PathVariable String name, Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            userService.addWishList(user.getUsername(), name);
            return "redirect:/scratch";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/visited/{name}")
    public String addToVisited(@PathVariable String name, Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            userService.addToVisited(user.getUsername(), name);
            return "redirect:/scratch";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/favorites/{name}")
    public String addToFavorites(@PathVariable String name, Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            userService.addToFavorites(user.getUsername(), name);
            return "redirect:/scratch";
        } else {
            return "redirect:/login";
        }
    }
}
