package com.example.dians_proba.repository.inmemory;

import com.example.dians_proba.model.Monument;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.example.dians_proba.bootstrap.DataHolder;

@Repository
public class InMemoryMonumentRepository {
    public List<Monument> listAllMonuments() {
        return DataHolder.monuments;
    }
    public Optional<Monument> findByName(String name) {
        return DataHolder.monuments.stream().filter(r->r.getName().equals(name)).findFirst();
    }
}
