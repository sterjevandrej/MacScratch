package com.example.dians_proba.service.impl;

import com.example.dians_proba.model.Monument;
import com.example.dians_proba.model.User;
import com.example.dians_proba.model.Wish;
import com.example.dians_proba.repository.MonumentRepository;
import com.example.dians_proba.repository.UserRepository;
import com.example.dians_proba.repository.WishRepository;
import com.example.dians_proba.service.WishService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishServiceImpl implements WishService {
    private final UserRepository userRepository;
    private final MonumentRepository monumentRepository;
    private final WishRepository wishRepository;

    public WishServiceImpl(UserRepository userRepository, MonumentRepository monumentRepository, WishRepository wishRepository) {
        this.userRepository = userRepository;
        this.monumentRepository = monumentRepository;
        this.wishRepository = wishRepository;
    }

    @Override
    public void addToWishList(String username, String name) {
        User user = userRepository.findByUsername(username).orElse(null);
        Monument monument = monumentRepository.findByName(name);
        Wish wish = new Wish(user, monument);
        //if(monument does not exist in wishRepo)
//        if(wishRepository.findByMonument(monument).isEmpty())
        wishRepository.save(wish);
    }

    @Override
    public List<Monument> getWishList(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        List<Wish> wishes = wishRepository.findByUser(user);
        return wishes.stream().map(Wish::getMonument).collect(Collectors.toList());
    }
}
