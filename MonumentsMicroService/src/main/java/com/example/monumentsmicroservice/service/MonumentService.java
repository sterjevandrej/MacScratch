package com.example.monumentsmicroservice.service;

import com.example.monumentsmicroservice.model.Monument;

import java.util.List;

public interface MonumentService {
    List<Monument> listAllMonuments();
//    Monument findMonumentByName(String name);
//    List<Monument> findAllMonumentsByName(String name);
//    List<Monument> findMonumentByLatitudeAndLongitude(String lat, String lon);
}