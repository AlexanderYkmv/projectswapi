package dev.alexander.demo.repository;

import org.springframework.data.repository.CrudRepository;
import dev.alexander.demo.model.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
    
}