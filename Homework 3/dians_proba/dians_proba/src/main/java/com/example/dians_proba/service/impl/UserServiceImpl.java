package com.example.dians_proba.service.impl;

import com.example.dians_proba.model.Monument;
import com.example.dians_proba.model.User;
import com.example.dians_proba.model.exceptions.InvalidUsernameOrPasswordException;
import com.example.dians_proba.model.exceptions.NotLoggedInException;
import com.example.dians_proba.model.exceptions.PasswordsDoNotMatchException;
import com.example.dians_proba.model.exceptions.UsernameAlreadyExistsException;
import com.example.dians_proba.repository.MonumentRepository;
import com.example.dians_proba.repository.UserRepository;
import com.example.dians_proba.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.password.PasswordEncoder; //NOT REALLY NECESSARY1

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    public final MonumentRepository monumentRepostory;
    public final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;  //NOT REALLY NECESSARY2

    public UserServiceImpl(MonumentRepository monumentRepostory, UserRepository userRepository) {
        this.monumentRepostory = monumentRepostory;
        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder; //NOT REALLY NECESSARY3
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void register(String username, String password, String repeatPassword, String name, String surname) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if (this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(name, surname, username, password);
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void addWishList(String username, String name) {
        Monument monument = monumentRepostory.findByName(name);
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            user.get().getWishList().add(monument);
        } else {
            throw new NotLoggedInException();
        }
    }

    @Transactional
    @Override
    public void addToVisited(String username, String name) {
        Monument monument = monumentRepostory.findByName(name);
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            user.get().getVisitedPlaces().add(monument);
        } else {
            throw new NotLoggedInException();
        }
    }

    @Transactional
    @Override
    public void addToFavorites(String username, String name) {
        Monument monument = monumentRepostory.findByName(name);
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            user.get().getFavouritePlaces().add(monument);
        } else {
            throw new NotLoggedInException();
        }
    }

    @Override
    public List<Monument> getWishList(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.get().getWishList();
    }

    @Override
    public List<Monument> getVisitedList(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.get().getVisitedPlaces();
    }

    @Override
    public List<Monument> getFavouritesList(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.get().getFavouritePlaces();
    }

}
