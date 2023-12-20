package com.example.dians_proba.web;

import com.example.dians_proba.model.Monument;
import com.example.dians_proba.model.User;
import com.example.dians_proba.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/list")
public class AssistantController {
    private final UserService userService;

    public AssistantController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/wishlist")
    public String wishlist(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("monuments", userService.getWishList(user.getUsername()));
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
            model.addAttribute("monuments", userService.getVisitedList(user.getUsername()));
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
            model.addAttribute("monuments", userService.getFavouritesList(user.getUsername()));
            model.addAttribute("bodyContent", "favourites");
        } else {
            model.addAttribute("bodyContent", "login_1");
        }
        return "master_template";
    }
}
