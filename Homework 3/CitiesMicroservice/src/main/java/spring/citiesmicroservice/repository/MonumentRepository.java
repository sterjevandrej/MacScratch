package spring.citiesmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.citiesmicroservice.model.Monument;

import java.util.List;

public interface MonumentRepository extends JpaRepository<Monument, Long> {
    Monument findByName(String name);
    List<Monument> findMonumentsByName(String name);

    List <Monument> findByLatLikeAndLonLike(String lat, String lon) ;
}