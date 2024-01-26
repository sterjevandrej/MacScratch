package com.example.dians_proba.repository;

import com.example.dians_proba.model.Monument;
import com.example.dians_proba.model.User;
import com.example.dians_proba.model.Visited;
import com.example.dians_proba.model.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VisitedRepository extends JpaRepository<Visited,Long> {
    List<Visited> findByUser(User user);
}
