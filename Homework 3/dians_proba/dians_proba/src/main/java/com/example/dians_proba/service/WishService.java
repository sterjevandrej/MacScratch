package com.example.dians_proba.service;

import com.example.dians_proba.model.Monument;

import java.util.List;

public interface WishService {
    void addToWishList(String username, String name);
    List<Monument> getWishList(String username);
}
