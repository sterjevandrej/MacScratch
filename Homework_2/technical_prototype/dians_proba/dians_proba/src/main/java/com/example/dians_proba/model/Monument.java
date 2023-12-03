package com.example.dians_proba.model;

import lombok.Data;

@Data
public class Monument {
    String name;
    String enName;
    String religion;
    String website;
    String opening_hours;
    String phone;
    String email;
    String id;
    String lat;
    String lon;

    public Monument(String name, String enName, String religion, String website,
                    String opening_hours, String phone, String email, String id, String lat, String lon) {
        this.name = name;
        this.enName = enName;
        this.religion = religion;
        this.website = website;
        this.opening_hours = opening_hours;
        this.phone = phone;
        this.email = email;
        this.id = id;
        this.lat = lat;
        this.lon = lon;
    }
}
