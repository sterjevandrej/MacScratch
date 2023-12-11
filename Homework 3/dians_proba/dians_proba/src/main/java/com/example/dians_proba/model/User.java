package com.example.dians_proba.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {
    private String name;
    private String surname;
    private String username;
    private String password;

    private String feedback;
    private boolean isSatisfied;

    private List<Monument> visitedPlaces;
    private List<Monument> wishList;
    private List<Monument> favouritePlaces;

    public User(String name, String surname, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.feedback = "";
        this.isSatisfied = true;
        visitedPlaces = new ArrayList<>();
        wishList = new ArrayList<>();
        favouritePlaces = new ArrayList<>();
    }
}
