package com.example.dians_proba.repository;

import com.example.dians_proba.model.Monument;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.example.dians_proba.bootstrap.DataHolder;

@Repository
public class MonumentRepository {
    public List<Monument> listAllMonuments() {
        return DataHolder.monuments;
    }
}
