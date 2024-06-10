package dev.alexander.demo.mapper;

import java.util.HashSet;
import java.util.Set;
import org.mapstruct.Mapper;
import dev.alexander.demo.dto.FilmCreateRequest;
import dev.alexander.demo.dto.FilmResponse;
import dev.alexander.demo.model.Film;
import dev.alexander.demo.model.Person;
import dev.alexander.demo.model.Planet;
import dev.alexander.demo.model.Vehicle;

@Mapper
public interface FilmMapper {
    
    public Film filmFromDto(FilmCreateRequest dto);
    
    
    public FilmResponse responseFromFilm(Film film);

    public static Set<String> personUrlsFromFilm(Set<Person> persons){
        Set<String> personUrls = new HashSet<>();

        if(persons != null){
            for(Person person : persons){
                personUrls.add("http://localhost:8080/swapi/persons/" + person.getId());
            }
        }

        return personUrls;
    }

    public static Set<String> vehicleUrlsFromFilm(Set<Vehicle> vehicles){
        Set<String> vehicleUrls = new HashSet<>();

       if(vehicles != null){
        for(Vehicle vehicle : vehicles){
            vehicleUrls.add("http://localhost:8080/swapi/vehicles/" + vehicle.getId());
        }
       }

        return vehicleUrls;
    }

    public static Set<String> planetUrlsFromFilm(Set<Planet> planets){
        Set<String> planetUrls = new HashSet<>();

       if (planets != null){
        for(Planet planet : planets){
            planetUrls.add("http://localhost:8080/swapi/planets/" + planet.getId());
        }
       }

        return planetUrls;
    }


    
}