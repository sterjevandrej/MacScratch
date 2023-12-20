package com.example.dians_proba.bootstrap;

import com.example.dians_proba.model.Monument;
import com.example.dians_proba.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Monument> monuments = null;
    public static List<User> users = null;

    @PostConstruct
    public void init() {
        monuments = new ArrayList<>();
        users = new ArrayList<>();
        monuments.add(new Monument("Манастир Света Петка", "Saint Petka Monastery","4485913838", "41.1291432"));
        monuments.add(new Monument("Музеј на град Берово", "Berovo Town Museum","478699817", "41.7077548"));
        monuments.add(new Monument("Саат-кула",null, "42.0792053",null));
        monuments.add(new Monument("Невена Георгиева-Дуња", null,"41.993726",null));
        monuments.add(new Monument("Свети Спас",null,"41.0207827",null));
        monuments.add(new Monument("Пресвета Богородица",null,"42.0719506",null));
        users.add(new User("Ana", "Banana", "anabanana", "123456"));
    }

}
