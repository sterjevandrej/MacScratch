package com.example.dians_proba.service.impl;

import com.example.dians_proba.model.Monument;
import com.example.dians_proba.repository.MonumentRepository;
import com.example.dians_proba.service.MonumentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonumentServiceImpl implements MonumentService {
    public final MonumentRepository monumentRepostory;

    public MonumentServiceImpl(MonumentRepository monumentRepostory) {
        this.monumentRepostory = monumentRepostory;
    }
    @Override
    public List<Monument> listAllMonumentsSine() {
        return monumentRepostory.listAllMonuments();
    }
}
