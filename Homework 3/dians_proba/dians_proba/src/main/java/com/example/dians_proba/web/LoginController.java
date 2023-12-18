package com.example.dians_proba.web;

import com.example.dians_proba.model.User;
import com.example.dians_proba.model.exceptions.InvalidUserCredentialsException;
import com.example.dians_proba.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getLoginPage(Model model){
        model.addAttribute("bodyContent", "login_1");
        return "master_template";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model) {
        User user = null;
        try{
            user = this.authService.login(request.getParameter("username"),
                    request.getParameter("password"));
            request.getSession().setAttribute("user", user);
            return "redirect:/home";
        }
        catch (InvalidUserCredentialsException exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            model.addAttribute("bodyContent", "invalidPage");
            return "master_template";
        }
    }
}
