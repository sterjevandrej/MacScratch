package com.example.dians_proba.web;

import com.example.dians_proba.model.Monument;
import com.example.dians_proba.model.User;
import com.example.dians_proba.model.exceptions.InvalidUserCredentialsException;
import com.example.dians_proba.service.AuthService;
import com.example.dians_proba.service.MonumentService;
import com.example.dians_proba.service.VisitedService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final AuthService authService;
    private final MonumentService monumentService;
    private final VisitedService visitedService;

    public LoginController(AuthService authService, MonumentService monumentService, VisitedService visitedService) {
        this.authService = authService;
        this.monumentService = monumentService;
        this.visitedService = visitedService;
    }

    @GetMapping
    public String getLoginPage(Model model) {
        model.addAttribute("bodyContent", "login_1");
        return "master_template";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model) {
        User user = null;
        try {
//            System.out.println("Latitude: " + latitude);
//            System.out.println("Longitude: " + longitude);
            user = this.authService.login(request.getParameter("username"),
                    request.getParameter("password"));
            request.getSession().setAttribute("user", user);

//            user = (User) request.getSession().getAttribute("user");
//
//            String latitudeStr = String.valueOf(latitude);
//            String longitudeStr = String.valueOf(longitude);
//
//            latitudeStr = latitudeStr.substring(0, latitudeStr.length() - 1);
//            longitudeStr = longitudeStr.substring(0, longitudeStr.length() - 1);
//
//            List<Monument> nearbyMonuments = monumentService.findMonumentByLatitudeAndLongitude(latitudeStr, longitudeStr);
//            nearbyMonuments.stream()
//                    .forEach(monument -> visitedService.addToVisitedList(request.getParameter("username"), monument.getName()));

            return "redirect:/home";
        } catch (InvalidUserCredentialsException exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            model.addAttribute("bodyContent", "login_1");
            return "master_template";
        }
    }
}
