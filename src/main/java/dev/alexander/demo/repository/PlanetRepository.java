package dev.alexander.demo.repository;

import org.springframework.data.repository.CrudRepository;
import dev.alexander.demo.model.Planet;

public interface PlanetRepository extends CrudRepository<Planet, Integer> {
    
}