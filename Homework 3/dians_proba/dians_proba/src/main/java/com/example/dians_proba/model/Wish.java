package com.example.dians_proba.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
<<<<<<< HEAD
@IdClass(WishId.class)
@NoArgsConstructor
public class Wish {
    @Id
    @ManyToOne
    private User user;

    @Id
=======
@NoArgsConstructor
public class Wish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

>>>>>>> 6ceb915b81221ff898b9ac081bbc2722c762404a
    @ManyToOne
    private Monument monument;

    public Wish(User user, Monument monument) {
        this.user = user;
        this.monument = monument;
    }
}
