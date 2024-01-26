package com.example.monumentsmicroservice.repository;

import com.example.monumentsmicroservice.model.Monument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonumentRepository extends JpaRepository<Monument, Long> {
    Monument findByName(String name);
    List<Monument> findMonumentsByName(String name);
    List <Monument> findByLatLikeAndLonLike(String lat, String lon) ;
}