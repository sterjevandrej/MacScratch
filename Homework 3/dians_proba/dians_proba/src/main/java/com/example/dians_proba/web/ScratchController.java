package com.example.dians_proba.web;

import com.example.dians_proba.model.User;
import com.example.dians_proba.service.*;
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
    private final WishService wishService;
    private final VisitedService visitedService;
    private final FavoritesService favoritesService;

    public ScratchController(MonumentService monumentService, UserService userService, WishService wishService, VisitedService visitedService, FavoritesService favoritesService) {
        this.monumentService = monumentService;
        this.wishService = wishService;
        this.visitedService = visitedService;
        this.favoritesService = favoritesService;
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
            wishService.addToWishList(user.getUsername(), name);
            return "redirect:/scratch";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/visited/{name}")
    public String addToVisited(@PathVariable String name, Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            visitedService.addToVisitedList(user.getUsername(), name);
            return "redirect:/scratch";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/favorites/{name}")
    public String addToFavorites(@PathVariable String name, Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            favoritesService.addToFavoritesList(user.getUsername(), name);
            return "redirect:/scratch";
        } else {
            return "redirect:/login";
        }
    }
}
