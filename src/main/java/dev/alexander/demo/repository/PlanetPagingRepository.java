package dev.alexander.demo.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import dev.alexander.demo.model.Planet;

public interface PlanetPagingRepository extends PagingAndSortingRepository<Planet, Integer> {
    
}
