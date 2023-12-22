package com.example.dians_proba.service;

import com.example.dians_proba.model.Monument;
import com.example.dians_proba.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);

    void register(String username, String password, String repeatPassword, String name, String surname);

    void setFeedbackAndSatisfied (String username, String feedback, Boolean satisfied);
}
