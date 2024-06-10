package dev.alexander.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.alexander.demo.dto.PersonCreateRequest;
import dev.alexander.demo.dto.PersonFilmsResponse;
import dev.alexander.demo.dto.PersonResponse;
import dev.alexander.demo.dto.PersonVehiclesResponse;
import dev.alexander.demo.dto.SetFilmsRequest;
import dev.alexander.demo.dto.SetVehiclesRequest;
import dev.alexander.demo.dto.SwapiPage;
import dev.alexander.demo.mapper.PersonMapper;
import dev.alexander.demo.model.Person;
import dev.alexander.demo.service.PersonService;


@RestController
@RequestMapping("/swapi/persons")
public class PersonController {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonService personService;

   


    @PostMapping(value = "")
    public List<PersonCreateRequest> postAllPersons(@RequestBody List<PersonCreateRequest> requestList){


        List<Person> personList = new ArrayList<>();
        personList =  personMapper.personListFromRequestList(requestList);
        
        List<PersonCreateRequest> responseList = new ArrayList<>();
        for(Person person : personList){
            Person savedPerson = personService.save(person);
            PersonCreateRequest response = personMapper.requestFromPerson(savedPerson);
            responseList.add(response);
        }

        return responseList;
    }


    @GetMapping(name= "", produces = "application/json")
    public SwapiPage<PersonResponse> getAllPersons(
            @RequestParam(required = false, defaultValue = "1") Integer currPage) {
                Page<PersonResponse> personPage = 
                personService.fetchAll(currPage - 1, 10).map(personMapper::responseFromPerson);

                for(PersonResponse response : personPage.getContent()){
                    response.setUrl("http://localhost:8080/swapi/persons/" + response.getId());
                }

               
            
        return new SwapiPage<>(personPage, "http://localhost:8080/swapi/persons?currPage=" + (currPage + 1), "http://localhost:8080/swapi/persons?currPage=" + (currPage - 1));
    }

    @GetMapping(value = "/{personId}")
    public ResponseEntity<PersonResponse> getById(@PathVariable Integer personId){
        Person person = personService.fetchById(personId);
        PersonResponse response = personMapper.responseFromPerson(person);
        response.setUrl("http://localhost:8080/swapi/persons/" + response.getId());

        return ResponseEntity.ok().body(response);
    }

   

    @PutMapping(value = "/{personId}/films")
    public PersonFilmsResponse setAllPersonFilms(@PathVariable String personId, @RequestBody SetFilmsRequest films) {
        
        Set<Integer> personFilms = personService.setPersonFilms(personId, films.getSetFilms());

        PersonFilmsResponse result = PersonFilmsResponse.builder().personFilmIds(personFilms).build();
        
        return result;
    }

    @PutMapping(value = "/{personId}/vehicles")
    public PersonVehiclesResponse setAllPersonVehicles(@PathVariable String personId, @RequestBody SetVehiclesRequest vehicles) {
        
        Set<Integer> personVehicles = personService.setPersonVehicles(personId, vehicles.getSetVehicles());

        PersonVehiclesResponse result = PersonVehiclesResponse.builder().personVehicleIds(personVehicles).build();
        
        return result;
    }


   

   
}
