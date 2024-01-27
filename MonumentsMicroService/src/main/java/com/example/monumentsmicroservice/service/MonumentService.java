package com.example.monumentsmicroservice.service;

import com.example.monumentsmicroservice.model.Monument;

import java.util.List;

public interface MonumentService {
    List<Monument> listAllMonuments();
}