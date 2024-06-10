package dev.alexander.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.alexander.demo.dto.PlanetCreateRequest;
import dev.alexander.demo.dto.PlanetResponse;
import dev.alexander.demo.dto.SwapiPage;
import dev.alexander.demo.mapper.PlanetMapper;
import dev.alexander.demo.model.Planet;
import dev.alexander.demo.service.PlanetService;

@RestController
@RequestMapping("/swapi/planets")
public class PlanetController {

    @Autowired
    private PlanetMapper planetMapper;

    @Autowired
    private PlanetService planetService;

   

    @PostMapping(value = "")
    public List<PlanetResponse> postAllPlanets(@RequestBody List<PlanetCreateRequest> requestList){

        List<Planet> planetList = new ArrayList<>();
        planetList =  planetMapper.planetListFromRequestList(requestList);
        
        List<PlanetResponse> responseList = new ArrayList<>();
        for(Planet planet : planetList){
            Planet savedPlanet = planetService.save(planet);
            PlanetResponse response = planetMapper.responseFromPlanet(savedPlanet);
            responseList.add(response);
        }

        return responseList;
    }


    @GetMapping(name = "", produces = "application/json")
    public SwapiPage<PlanetResponse> getAllFilms( @RequestParam (defaultValue = "1",  required = false) Integer currPage){

        Page<PlanetResponse> planetPage = planetService.fetchAll(currPage - 1, 10).map(planetMapper::responseFromPlanet);

        for(PlanetResponse response : planetPage.getContent()){
            response.setUrl("http://localhost:8080/swapi/planets/" + response.getId());
        }

        return new SwapiPage<>(planetPage, "http://localhost:8080/swapi/planets?currPage=" + (currPage + 1), "http://localhost:8080/swapi/planets?currPage=" + (currPage - 1) );

    }

    @GetMapping(value = "/{planetId}")
    public ResponseEntity<PlanetResponse> getById(@PathVariable Integer planetId){
        Planet planet  = planetService.fetchById(planetId);
        PlanetResponse response = planetMapper.responseFromPlanet(planet);
        response.setUrl("http://localhost:8080/swapi/planets/" + response.getId());

        return ResponseEntity.ok().body(response);
    }
}
