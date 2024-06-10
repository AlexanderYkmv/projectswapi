package dev.alexander.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import dev.alexander.demo.error.ObjectNotFoundException;
import dev.alexander.demo.model.Film;
import dev.alexander.demo.model.Vehicle;
import dev.alexander.demo.repository.FilmPagingRepository;
import dev.alexander.demo.repository.FilmRepository;
import dev.alexander.demo.repository.PlanetRepository;
import dev.alexander.demo.repository.VehicleRepository;


@Service
public class FilmService {

    @Autowired
    private FilmRepository repo;

    @Autowired
    private FilmPagingRepository pagingRepo;

    @Autowired
    private VehicleRepository vehicleRepo;

   


    @Autowired
    private PlanetRepository planetRepo;

    public Film save(Film film) {
        return repo.save(film);
    }

    public Page<Film> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public Film fetchById(Integer filmId){
        Film film = repo.findById(filmId).orElseThrow(() -> {
            throw new ObjectNotFoundException("Film Not Found", Film.class.getName(), filmId.toString());
        });
        return film;
    }

    public Set<Integer> setFilmVehicles(String filmId, Set<Integer> vehicleIds) {

        Film film = repo.findById(Integer.parseInt(filmId)).orElseThrow(() -> {
            throw new ObjectNotFoundException("Film Not Found", Film.class.getName(), filmId);
        });

        List<Vehicle> allFilmVehicles = (List<Vehicle>) vehicleRepo.findAllById(vehicleIds);

        film.setVehicles(new HashSet<>(allFilmVehicles));
        Film savedFilm = repo.save(film);

        Set<Integer> allFilmVehicleIds = new HashSet<>();
        for (Vehicle vehicle : savedFilm.getVehicles()) {
            allFilmVehicleIds.add(vehicle.getId());
        }

        return allFilmVehicleIds;
    }
}