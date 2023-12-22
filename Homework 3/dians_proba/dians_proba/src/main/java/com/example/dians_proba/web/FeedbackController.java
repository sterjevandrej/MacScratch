package com.example.dians_proba.web;


import com.example.dians_proba.model.User;
import com.example.dians_proba.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    private final UserService userService;

    public FeedbackController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public String getFeedbackPage(Model model) {
        model.addAttribute("bodyContent", "feedback");
        return "master_template";
    }

    @PostMapping("/{username}")
    public String addFeedbackAndSatisfied (@PathVariable String username, @RequestParam String feedback, @RequestParam Boolean satisfied) {
        userService.setFeedbackAndSatisfied(username, feedback, satisfied);
        return "redirect://scratch";
    }

}
