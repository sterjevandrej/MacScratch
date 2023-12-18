package com.example.dians_proba.service;

import com.example.dians_proba.model.User;

public interface AuthService {
    User login(String username, String password);
}
