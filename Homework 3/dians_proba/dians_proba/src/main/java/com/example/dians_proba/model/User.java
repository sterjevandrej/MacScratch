package com.example.dians_proba.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "app_users")
public class User {
    private String name;
    private String surname;
    @Id
    private String username;
    private String password;

    private String feedback;
    private boolean isSatisfied = true;

    @ManyToMany
    private List<Monument> visitedPlaces;
    @ManyToMany
    private List<Monument> wishList;
    @ManyToMany
    private List<Monument> favouritePlaces;

    public User(){

    }
    public User(String name, String surname, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.feedback = "";
//        visitedPlaces = new ArrayList<>();
//        wishList = new ArrayList<>();
//        favouritePlaces = new ArrayList<>();
    }
}
