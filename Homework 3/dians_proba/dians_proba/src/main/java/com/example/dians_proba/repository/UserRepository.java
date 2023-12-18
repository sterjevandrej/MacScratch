package com.example.dians_proba.repository;

import com.example.dians_proba.model.Monument;
import com.example.dians_proba.model.User;
import org.springframework.stereotype.Repository;
import com.example.dians_proba.bootstrap.DataHolder;

import java.util.Optional;

@Repository
public class UserRepository {

    public Optional<User> findByUsername(String username) {
        return DataHolder.users.stream().filter(r->r.getUsername().equals(username)).findFirst();
    }

    public void saveOrUpdate(User user) { // From 'public User' to 'public void' and removed return user;
        DataHolder.users.removeIf(r->r.getUsername().equals(user.getUsername()));
        DataHolder.users.add(user);
    }

    public Optional<User> findByUsernameAndPassword(String username, String password) {
        return DataHolder.users.stream().filter(r->r.getUsername().equals(username) && r.getPassword().equals(password)).findFirst();
    }

    public void addWishList(String username, Monument monument){
        User user = this.findByUsername(username).get();
        user.getWishList().add(monument);
        System.out.println("Whish list: "+ user.getWishList());
    }
    public void addToVisited(String username, Monument monument){
        User user = this.findByUsername(username).get();
        user.getVisitedPlaces().add(monument);
        System.out.println("Visited list: "+ user.getVisitedPlaces());
    }
    public void addToFavorites(String username, Monument monument){
        User user = this.findByUsername(username).get();
        user.getFavouritePlaces().add(monument);
        System.out.println("Fav list: "+ user.getFavouritePlaces());
    }

    public void listVisited(){

    }
    public void listFavourites(){

    }
    public void listWishList(){

    }
}
