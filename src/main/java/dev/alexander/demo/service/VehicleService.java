package dev.alexander.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import dev.alexander.demo.error.ObjectNotFoundException;
import dev.alexander.demo.model.Vehicle;
import dev.alexander.demo.repository.VehiclePagingRepository;
import dev.alexander.demo.repository.VehicleRepository;

@Service
public class VehicleService {
    

    @Autowired 
    private VehicleRepository repo;

    @Autowired
    private VehiclePagingRepository pagingRepo;


    public Vehicle save(Vehicle vehicle) {
        return repo.save(vehicle);
    }

    public Page<Vehicle> fetchAll(int currentPage, int pageSize){
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }


    public Vehicle fetchById(Integer vehicleId){
        Vehicle vehicle = repo.findById(vehicleId).orElseThrow(() -> {
            throw new ObjectNotFoundException("Vehicle Not Found", Vehicle.class.getName(), vehicleId.toString());
        });
        return vehicle;
    }
}