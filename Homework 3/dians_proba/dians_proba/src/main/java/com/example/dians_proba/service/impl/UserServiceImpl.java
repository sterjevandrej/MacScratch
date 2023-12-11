package com.example.dians_proba.service.impl;

import com.example.dians_proba.model.Monument;
import com.example.dians_proba.model.User;
import com.example.dians_proba.repository.MonumentRepository;
import com.example.dians_proba.repository.UserRepository;
import com.example.dians_proba.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    public final MonumentRepository monumentRepostory;
    public final UserRepository userRepository;

    public UserServiceImpl(MonumentRepository monumentRepostory, UserRepository userRepository) {
        this.monumentRepostory = monumentRepostory;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void addWishList(String username, String name) {
        Monument monument = monumentRepostory.findByName(name).get();
        userRepository.addWishList(username, monument);
    }
    @Override
    public void addToVisited(String username, String name) {
        Monument monument = monumentRepostory.findByName(name).get();
        userRepository.addToVisited(username, monument);
    }
    @Override
    public void addToFavorites(String username, String name) {
        Monument monument = monumentRepostory.findByName(name).get();
        userRepository.addToFavorites(username, monument);
    }
}
