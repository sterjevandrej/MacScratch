package com.example.dians_proba.service;

import com.example.dians_proba.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);

    void register(String username, String password, String repeatPassword, String name, String surname);

    void addWishList(String username, String name);

    void addToVisited(String username, String name);

    void addToFavorites(String username, String name);
}
