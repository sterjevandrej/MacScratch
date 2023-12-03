package com.example.dians_proba.web;

import com.example.dians_proba.service.MonumentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/scratch")
public class ScratchController {
    private final MonumentService monumentService;

    public ScratchController(MonumentService monumentService) {
        this.monumentService = monumentService;
    }

    @GetMapping
    public String listPlaces(Model model){
        model.addAttribute("monuments", monumentService.listAllMonumentsSine());
        return "scratch";
    }
}
