package spring.listsmicroservice.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.listsmicroservice.model.Monument;
import spring.listsmicroservice.model.User;
import spring.listsmicroservice.service.FavoritesService;
import spring.listsmicroservice.service.MonumentService;
import spring.listsmicroservice.service.VisitedService;
import spring.listsmicroservice.service.WishService;

import java.util.List;

@RestController
@RequestMapping("/list")
public class Controller {
    private final WishService wishService;
    private final VisitedService visitedService;
    private final FavoritesService favoritesService;
    private final MonumentService monumentService;

    public Controller(WishService wishService, VisitedService visitedService, FavoritesService favoritesService, MonumentService monumentService) {
        this.wishService = wishService;
        this.visitedService = visitedService;
        this.favoritesService = favoritesService;
        this.monumentService = monumentService;
    }

    /*Returns all wishlist monuments for the given user if the user is logged in */

    @GetMapping("/wishlist")
    public List<Monument> wishlist(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null)
            return wishService.getWishList(user.getUsername());//todo: ako e prazna listata da se prenasoci na najava vo glavniot proekt
        else
            return null;
    }

    /*Returns all visited monuments for the given user if the user is logged in */

    @GetMapping("/visited")
    public List<Monument> visited(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null)
            return visitedService.getVisitedList(user.getUsername());
        else
            return null;
    }

    /*Returns all favourite monuments for the given user if the user is logged in */

    @GetMapping("/favourites")
    public List<Monument> favourites(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null)
            return favoritesService.getFavoritesList(user.getUsername());
        else
            return null;
    }

    @PostMapping("/wishlist/{name}")
    public ResponseEntity<String> addToWishList(@PathVariable String name, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            wishService.addToWishList(user.getUsername(), name);
            return ResponseEntity.ok("addedToWish");
        } else {
            return ResponseEntity.status(401).body("Unauthorized");
        }
    }

    @PostMapping("/visited/{name}")
    public ResponseEntity<String> addToVisited(@PathVariable String name, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            visitedService.addToVisitedList(user.getUsername(), name);
            return ResponseEntity.ok("addedToVisited");
        } else {
            return ResponseEntity.status(401).body("Unauthorized");
        }
    }

    @PostMapping("/favorites/{name}")
    public ResponseEntity<String> addToFavorites(@PathVariable String name, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            favoritesService.addToFavoritesList(user.getUsername(), name);
            return ResponseEntity.ok("addedToFavorites");
        } else {
            return ResponseEntity.status(401).body("Unauthorized");
        }
    }
}
