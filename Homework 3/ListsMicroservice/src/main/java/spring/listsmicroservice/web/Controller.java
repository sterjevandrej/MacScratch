package spring.listsmicroservice.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.listsmicroservice.model.Monument;
import spring.listsmicroservice.model.User;
import spring.listsmicroservice.service.FavoritesService;
import spring.listsmicroservice.service.VisitedService;
import spring.listsmicroservice.service.WishService;

import java.util.List;

@RestController
@RequestMapping("/list")
public class Controller {
    private final WishService wishService;
    private final VisitedService visitedService;
    private final FavoritesService favoritesService;

    public Controller(WishService wishService, VisitedService visitedService, FavoritesService favoritesService) {
        this.wishService = wishService;
        this.visitedService = visitedService;
        this.favoritesService = favoritesService;
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
    public List<Monument> visited( Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null)
            return visitedService.getVisitedList(user.getUsername());
        else
            return null;
    }

    /*Returns all favourite monuments for the given user if the user is logged in */

    @GetMapping("/favourites")
    public List<Monument> favourites(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null)
            return favoritesService.getFavoritesList(user.getUsername());
        else
            return null;
    }
}
