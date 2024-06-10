package dev.alexander.demo.mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;
import dev.alexander.demo.dto.PersonCreateRequest;
import dev.alexander.demo.dto.PersonResponse;
import dev.alexander.demo.model.Film;
import dev.alexander.demo.model.Person;
import dev.alexander.demo.model.Planet;
import dev.alexander.demo.model.Vehicle;

@Mapper
public interface PersonMapper {
    
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "films", ignore = true)
    @Mapping(target = "planet", ignore = true)
    @Mapping(target = "updated", ignore = true)
    @Mapping(target = "vehicles", ignore = true)
    public Person personFromRequest(PersonCreateRequest request);

    public PersonCreateRequest requestFromPerson(Person person);


    
    public  PersonResponse responseFromPerson(Person person);

    public static String planetToString(Planet planet){
        if(planet == null) return "unknown";
        return "http://localhost:8080/swapi/planets/" + planet.getId();
    }

    public static Set<String> filmUrlsFromPerson(Set<Film> films){
        Set<String> filmUrls = new HashSet<>();

        for(Film film : films){
            filmUrls.add("http://localhost:8080/swapi/films/" + film.getId());
        }

        return filmUrls;
    }

    public static Set<String> vehicleUrlsFromPerson(Set<Vehicle> vehicles){
        Set<String> vehicleUrls = new HashSet<>();

        for(Vehicle vehicle : vehicles){
            vehicleUrls.add("http://localhost:8080/swapi/vehicles/" + vehicle.getId());
        }

        return vehicleUrls;

    }
   

    public List<Person> personListFromRequestList(List<PersonCreateRequest> requestList);

}