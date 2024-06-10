package dev.alexander.demo.controllers;

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
import dev.alexander.demo.dto.FilmCreateRequest;
import dev.alexander.demo.dto.FilmResponse;
import dev.alexander.demo.dto.SwapiPage;
import dev.alexander.demo.mapper.FilmMapper;
import dev.alexander.demo.model.Film;
import dev.alexander.demo.service.FilmService;

@RestController
@RequestMapping(value = "/swapi/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @Autowired
    private FilmMapper filmMapper;

    @PostMapping(value = "")
    public ResponseEntity<FilmResponse> postFilm(@RequestBody FilmCreateRequest request) {

        Film film = filmMapper.filmFromDto(request);
        Film savedFilm = filmService.save(film);
        FilmResponse response = filmMapper.responseFromFilm(savedFilm);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(name = "", produces = "application/json")
    public SwapiPage<FilmResponse> getAllPersons(
            @RequestParam(required = false, defaultValue = "1") Integer currPage) {
        Page<FilmResponse> filmPage = filmService.fetchAll(currPage - 1, 10).map(filmMapper::responseFromFilm);

        for (FilmResponse response : filmPage){
            response.setUrl("http://localhost:8080/swapi/films/" + response.getId());
        }

        return new SwapiPage<>(filmPage, "http://localhost:8080/swapi/films?currPage=" + (currPage + 1),
                "http://localhost:8080/swapi/films?currPage=" + (currPage - 1));

    }

    @GetMapping(value = "/{filmId}")
    public ResponseEntity<FilmResponse> getById(@PathVariable Integer filmId){
        Film film  = filmService.fetchById(filmId);
        FilmResponse response = filmMapper.responseFromFilm(film);
        response.setUrl("http://localhost:8080/swapi/films/" + response.getId());

        return ResponseEntity.ok().body(response);
    }
}