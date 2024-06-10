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
import dev.alexander.demo.model.Person;
import dev.alexander.demo.model.Vehicle;
import dev.alexander.demo.repository.FilmRepository;
import dev.alexander.demo.repository.PersonPagingRepository;
import dev.alexander.demo.repository.PersonRepository;
import dev.alexander.demo.repository.VehicleRepository;


@Service
public class PersonService {

    @Autowired 
    private PersonRepository repo;

    @Autowired 
    private VehicleRepository vehicleRepo;


    @Autowired 
    private FilmRepository filmRepo;

    @Autowired
    private PersonPagingRepository pagingRepo;


    public Person save(Person person) {
        return repo.save(person);
    }

    public Page<Person> fetchAll(int currentPage, int pageSize){
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));


    }

    public Person fetchById(Integer personId){
        Person person = repo.findById(personId).orElseThrow(() -> {
            throw new ObjectNotFoundException("Person Not Found", Person.class.getName(), personId.toString());
        });
        return person;
    }

    public Set<Integer> setPersonFilms(String personId, Set<Integer> personFilmIds) {
        Person person = repo.findById(Integer.parseInt(personId)).orElseThrow(() -> {
            throw new ObjectNotFoundException("Person Not Found", Person.class.getName(), personId);
        });

        List<Film> allPersonFilms =
                (List<Film>) filmRepo.findAllById(personFilmIds);

        person.setFilms(new HashSet<>(allPersonFilms));
        Person savedPerson = repo.save(person);

        Set<Integer> allPersonFilmIds = new HashSet<>();
        for (Film film : savedPerson.getFilms()) {
            allPersonFilmIds.add(film.getId());
        }

        return allPersonFilmIds;
    }

    public Set<Integer> setPersonVehicles(String personId, Set<Integer> personVehicleIds) {
        Person person = repo.findById(Integer.parseInt(personId)).orElseThrow(() -> {
            throw new ObjectNotFoundException("Person Not Found", Person.class.getName(), personId);
        });

        List<Vehicle> allPersonvehicles =
                (List<Vehicle>) vehicleRepo.findAllById(personVehicleIds);

        person.setVehicles(new HashSet<>(allPersonvehicles));
        Person savedPerson = repo.save(person);

        Set<Integer> allPersonVehicleIds = new HashSet<>();
        for (Vehicle vehicle : savedPerson.getVehicles()) {
            allPersonVehicleIds.add(vehicle.getId());
        }

        return allPersonVehicleIds;
    }

    
}