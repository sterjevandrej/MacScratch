package com.example.dians_proba.repository;

import com.example.dians_proba.model.Monument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentRepository extends JpaRepository<Monument, Long> {
    Monument findByName(String name);
}
