package com.example.dians_proba.service;

import com.example.dians_proba.model.City;

import java.util.List;

public interface CityService {
    City findByCityName(String name);
    List<City> findCities();
}
