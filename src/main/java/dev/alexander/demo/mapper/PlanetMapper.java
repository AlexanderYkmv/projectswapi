package dev.alexander.demo.mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;
import dev.alexander.demo.dto.PlanetCreateRequest;
import dev.alexander.demo.dto.PlanetResponse;
import dev.alexander.demo.model.Film;
import dev.alexander.demo.model.Person;
import dev.alexander.demo.model.Planet;

@Mapper
public interface PlanetMapper {
    

   
    @Mapping(target = "residents", ignore = true)
    @Mapping(target = "films", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    public Planet planetFromRequest(PlanetCreateRequest request);

    // mapping Planet to PlanetResponse
    public PlanetResponse responseFromPlanet(Planet planet);

    public static Set<String> personUrlsFromPlanet(Set<Person> persons){
        Set<String> personUrls = new HashSet<>();

        for(Person person : persons){
            personUrls.add("http://localhost:8080/swapi/persons/" + person.getId());
        }

        return personUrls;

    }
    public static Set<String> filmUrlsFromPlanet(Set<Film> films){
        Set<String> filmUrls = new HashSet<>();

        for(Film film : films){
            filmUrls.add("http://localhost:8080/swapi/films/" + film.getId());
        }

        return filmUrls;

    }

    public List<Planet> planetListFromRequestList(List<PlanetCreateRequest> requestList);

    
}