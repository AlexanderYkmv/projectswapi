package dev.alexander.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import dev.alexander.demo.error.ObjectNotFoundException;
import dev.alexander.demo.model.Planet;
import dev.alexander.demo.repository.PlanetPagingRepository;
import dev.alexander.demo.repository.PlanetRepository;

@Service
public class PlanetService {
    
    @Autowired 
    private PlanetRepository repo;

    @Autowired
    private PlanetPagingRepository pagingRepo;


    public Planet save(Planet planet) {
        return repo.save(planet);
    }

    public Page<Planet> fetchAll(int currentPage, int pageSize){
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public Planet fetchById(Integer planetId){
        Planet planet = repo.findById(planetId).orElseThrow(() -> {
            throw new ObjectNotFoundException("Planet Not Found", Planet.class.getName(), planetId.toString());
        });
        return planet;
    }
}
