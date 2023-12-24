// IGNORE THIS CODE
//package com.example.dians_proba.web;
//
//import com.example.dians_proba.model.Monument;
//import com.example.dians_proba.model.User;
//import com.example.dians_proba.service.MonumentService;
//import com.example.dians_proba.service.VisitedService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
//@Controller
//public class LocationController {
//
//    private final MonumentService monumentService;
//    private final VisitedService visitedService;
//
//    public LocationController(MonumentService monumentService, VisitedService visitedService) {
//        this.monumentService = monumentService;
//        this.visitedService = visitedService;
//    }
//
//
//    @GetMapping("/getLocation")
//    public String getLocation(
//            @RequestParam("latitude") double latitude,
//            @RequestParam("longitude") double longitude, HttpServletRequest request) {
//
//
//        System.out.println("Latitude: " + latitude);
//        System.out.println("Longitude: " + longitude);
//        User user = (User) request.getSession().getAttribute("user");
//
//        String latitudeStr = String.valueOf(latitude);
//        String longitudeStr = String.valueOf(longitude);
//
//        latitudeStr = latitudeStr.substring(0, latitudeStr.length() - 1);
//        longitudeStr = longitudeStr.substring(0, longitudeStr.length() - 1);
//
//        List<Monument> nearbyMonuments = monumentService.findMonumentByLatitudeAndLongitude(latitudeStr, longitudeStr);
//        nearbyMonuments.stream()
//                .forEach(monument -> visitedService.addToVisitedList(user.getUsername(), monument.getName()));
//        return "map";
//    }
//
//}