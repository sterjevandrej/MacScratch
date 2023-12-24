package com.example.dians_proba.repository;


import com.example.dians_proba.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findCitiesByName(String name);
    List<City> findAll();
}
