package com.example.dians_proba.service;

import com.example.dians_proba.model.Monument;

import java.util.List;

public interface MonumentService {
    List<Monument> listAllMonumentsSine();
    Monument findMonumentByName(String name);
    List<Monument> findAllMonumentsByName(String name);
    List<Monument> findMonumentByLatitudeAndLongitude(String lat, String lon);
}
