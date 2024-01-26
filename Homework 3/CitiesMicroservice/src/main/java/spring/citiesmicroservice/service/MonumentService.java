package spring.citiesmicroservice.service;

import spring.citiesmicroservice.model.Monument;

import java.util.List;

public interface MonumentService {
    List<Monument> listAllMonumentsSine();
    Monument findMonumentByName(String name);
    List<Monument> findAllMonumentsByName(String name);
    List<Monument> findMonumentByLatitudeAndLongitude(String lat, String lon);
}
