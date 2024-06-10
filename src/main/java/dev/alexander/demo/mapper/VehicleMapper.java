package dev.alexander.demo.mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;
import dev.alexander.demo.dto.VehicleDto;
import dev.alexander.demo.dto.VehicleResponse;
import dev.alexander.demo.model.Film;
import dev.alexander.demo.model.Person;
import dev.alexander.demo.model.Vehicle;

@Mapper
public interface VehicleMapper {
    
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "films", ignore = true)
    @Mapping(target = "pilots", ignore = true)
    @Mapping(target = "updated", ignore = true)
    public Vehicle vehicleFromDto (VehicleDto dto);

    public VehicleDto dtoFromVehicle (Vehicle vehicle);

    public VehicleResponse responseFromVehicle(Vehicle vehicle);


    public static Set<String> personsUrlsFromStarship(Set<Person> pilots){

        Set<String> personUrls = new HashSet<>();

        for(Person person : pilots){
            personUrls.add("http://localhost:8080/swapi/persons/" + person.getId());
        }

        return personUrls;

    }

    public static Set<String> filmUrlsFromStarship(Set<Film> films){
        Set<String> filmUrls = new HashSet<>();

        for(Film film : films){
            filmUrls.add("http://localhost:8080/swapi/films/" + film.getId());
        }

        return filmUrls;

    }

    public List<Vehicle> vehicleListFromRequestList(List<VehicleDto> requestList);

}
