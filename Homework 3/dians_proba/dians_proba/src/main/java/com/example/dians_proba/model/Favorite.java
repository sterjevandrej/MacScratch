package com.example.dians_proba.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
<<<<<<< HEAD
@IdClass(FavouriteId.class)
@NoArgsConstructor
public class Favorite {
    @Id
    @ManyToOne
    private User user;

    @Id
=======
@NoArgsConstructor
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

>>>>>>> 6ceb915b81221ff898b9ac081bbc2722c762404a
    @ManyToOne
    private Monument monument;

    public Favorite(User user, Monument monument) {
        this.user = user;
        this.monument = monument;
    }
}
