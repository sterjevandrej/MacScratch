package com.example.dians_proba.repository;

import com.example.dians_proba.model.Monument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonumentRepository extends JpaRepository<Monument, Long> {
    Monument findByName(String name);
    List<Monument> findMonumentsByName(String name);

    List <Monument> findByLatLikeAndLonLike(String lat, String lon) ;
}
