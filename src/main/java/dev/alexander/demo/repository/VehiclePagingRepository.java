package dev.alexander.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import dev.alexander.demo.model.Vehicle;

public interface VehiclePagingRepository extends PagingAndSortingRepository<Vehicle, Integer> {
    
}
