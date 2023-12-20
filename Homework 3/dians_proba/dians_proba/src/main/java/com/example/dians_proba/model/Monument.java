package com.example.dians_proba.model;

<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
=======
import jakarta.persistence.*;
>>>>>>> 6ceb915b81221ff898b9ac081bbc2722c762404a
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
<<<<<<< HEAD
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
=======
@NoArgsConstructor
public class Monument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String enName;
    private String religion;
    private String website;
    private String opening_hours;
    private String phone;
    private String email;

    private String lat;
    private String lon;

    public Monument(String name, String enName, String religion, String website,
                    String opening_hours, String phone, String email, String lat, String lon) {
        this.name = name;
        this.enName = enName;
        this.religion = religion;
        this.website = website;
        this.opening_hours = opening_hours;
        this.phone = phone;
        this.email = email;
>>>>>>> 6ceb915b81221ff898b9ac081bbc2722c762404a
        this.lat = lat;
        this.lon = lon;
    }
}
