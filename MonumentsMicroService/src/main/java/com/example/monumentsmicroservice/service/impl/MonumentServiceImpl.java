package com.example.monumentsmicroservice.service.impl;

import com.example.monumentsmicroservice.model.Monument;
import com.example.monumentsmicroservice.repository.MonumentRepository;
import com.example.monumentsmicroservice.service.MonumentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonumentServiceImpl implements MonumentService {
    public final MonumentRepository monumentRepository;

    public MonumentServiceImpl(MonumentRepository monumentRepository) {
        this.monumentRepository = monumentRepository;
    }

    @Override
    public List<Monument> listAllMonuments() {
        return this.monumentRepository.findAll();
    }

}