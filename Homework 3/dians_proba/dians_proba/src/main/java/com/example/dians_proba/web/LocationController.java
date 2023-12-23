package com.example.dians_proba.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LocationController {

    @GetMapping("/getLocation")
    public String getLocation(
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude) {

        // Access latitude and longitude directly
        System.out.println("Latitude: " + latitude);
        System.out.println("Longitude: " + longitude);

        return "map";
    }
}