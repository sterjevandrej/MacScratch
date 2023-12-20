package com.example.dians_proba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Monument {
    @Id
    String name;
    String enName;
//    String religion;
//    String website;
//    String opening_hours;
//    String phone;
//    String email;
//    String id;
    String lat;
    String lon;
    public Monument() {

    }
    public Monument(String name, String enName, String lat, String lon) {
        this.name = name;
        this.enName = enName;
//        this.religion = religion;
//        this.website = website;
//        this.opening_hours = opening_hours;
//        this.phone = phone;
//        this.email = email;
//        this.id = id;
        this.lat = lat;
        this.lon = lon;
    }
}
