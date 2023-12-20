package com.example.dians_proba.repository;

import com.example.dians_proba.model.Favorite;
import com.example.dians_proba.model.User;
import com.example.dians_proba.model.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUser(User user);
}
