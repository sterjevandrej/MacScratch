package spring.citiesmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.citiesmicroservice.model.City;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findCitiesByName(String name);
    List<City> findAll();
}
