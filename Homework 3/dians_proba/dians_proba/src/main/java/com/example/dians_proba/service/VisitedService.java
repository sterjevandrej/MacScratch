package com.example.dians_proba.service;

import com.example.dians_proba.model.Monument;

import java.util.List;

public interface VisitedService {
    void addToVisitedList(String username, String name);
    List<Monument> getVisitedList(String username);
}
