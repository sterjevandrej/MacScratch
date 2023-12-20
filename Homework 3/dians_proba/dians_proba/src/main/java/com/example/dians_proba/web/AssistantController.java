package com.example.dians_proba.web;

import com.example.dians_proba.model.User;
import com.example.dians_proba.service.FavoritesService;
import com.example.dians_proba.service.VisitedService;
import com.example.dians_proba.service.WishService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class AssistantController {
    private final WishService wishService;
    private final VisitedService visitedService;
    private final FavoritesService favoritesService;

    public AssistantController(WishService wishService, VisitedService visitedService, FavoritesService favoritesService) {
        this.wishService = wishService;
        this.visitedService = visitedService;
        this.favoritesService = favoritesService;
    }

    @GetMapping("/wishlist")
    public String wishlist(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("monuments", wishService.getWishList(user.getUsername()));
            model.addAttribute("bodyContent", "wishlist");
        } else {
            model.addAttribute("bodyContent", "login_1");
        }
        return "master_template";
    }

    @GetMapping("/visited")
    public String visited(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("monuments", visitedService.getVisitedList(user.getUsername()));
            model.addAttribute("bodyContent", "visited");
        } else {
            model.addAttribute("bodyContent", "login_1");
        }
        return "master_template";
    }

    @GetMapping("/favourites")
    public String favourites(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("monuments", favoritesService.getFavoritesList(user.getUsername()));
            model.addAttribute("bodyContent", "favourites");
        } else {
            model.addAttribute("bodyContent", "login_1");
        }
        return "master_template";
    }
}
