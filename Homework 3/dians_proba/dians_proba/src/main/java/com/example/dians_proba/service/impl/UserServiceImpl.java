package com.example.dians_proba.service.impl;

import com.example.dians_proba.model.Monument;
import com.example.dians_proba.model.User;
import com.example.dians_proba.model.exceptions.InvalidUsernameOrPasswordException;
import com.example.dians_proba.model.exceptions.PasswordsDoNotMatchException;
import com.example.dians_proba.model.exceptions.UsernameAlreadyExistsException;
import com.example.dians_proba.repository.MonumentRepository;
import com.example.dians_proba.repository.UserRepository;
import com.example.dians_proba.service.UserService;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.password.PasswordEncoder; //NOT REALLY NECESSARY1

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
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(name,surname,username,password);
        return userRepository.saveOrUpdate(user);
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
