package com.example.dians_proba.model;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class WishId implements Serializable {

    private User user;
    private Monument monument;

    public WishId(User user, Monument monument) {
        this.user = user;
        this.monument = monument;
    }
}