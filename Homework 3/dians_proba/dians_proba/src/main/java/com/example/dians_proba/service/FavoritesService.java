package com.example.dians_proba.service;

import com.example.dians_proba.model.Monument;

import java.util.List;

public interface FavoritesService {
    void addToFavoritesList(String username, String name);
    List<Monument> getFavoritesList(String username);
}
