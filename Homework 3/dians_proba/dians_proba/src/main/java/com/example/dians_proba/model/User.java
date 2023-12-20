package com.example.dians_proba.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
<<<<<<< HEAD
@Table(name = "app_users")
=======
@Table(name = "users")
@NoArgsConstructor
>>>>>>> 6ceb915b81221ff898b9ac081bbc2722c762404a
public class User {
    @Id
    private String username;
    private String name;
    private String surname;
<<<<<<< HEAD
    @Id
    private String username;
=======

>>>>>>> 6ceb915b81221ff898b9ac081bbc2722c762404a
    private String password;

    private String feedback;
    private boolean isSatisfied = true;

<<<<<<< HEAD
    @ManyToMany
    private List<Monument> visitedPlaces;
    @ManyToMany
    private List<Monument> wishList;
    @ManyToMany
    private List<Monument> favouritePlaces;

    public User(){

    }
=======
>>>>>>> 6ceb915b81221ff898b9ac081bbc2722c762404a
    public User(String name, String surname, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.feedback = "";
<<<<<<< HEAD
//        visitedPlaces = new ArrayList<>();
//        wishList = new ArrayList<>();
//        favouritePlaces = new ArrayList<>();
=======
        this.isSatisfied = true;
>>>>>>> 6ceb915b81221ff898b9ac081bbc2722c762404a
    }
}
