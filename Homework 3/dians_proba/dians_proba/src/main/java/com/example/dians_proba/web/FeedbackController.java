package com.example.dians_proba.web;


import com.example.dians_proba.model.User;
import com.example.dians_proba.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
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
    public String getFeedbackPage(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("bodyContent", "feedback");
        } else{
            model.addAttribute("bodyContent", "login_1");
        }
        return "master_template";
    }

    @PostMapping("/{username}")
    public String addFeedbackAndSatisfied (@PathVariable String username, @RequestParam String feedback, @RequestParam String satisfied) {
        boolean bool;
        bool = satisfied.equals("satisfied");
        userService.setFeedbackAndSatisfied(username, feedback, bool);
        return "redirect:/home";
    }

}