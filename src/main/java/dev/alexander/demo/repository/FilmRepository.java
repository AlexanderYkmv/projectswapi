package dev.alexander.demo.repository;

import org.springframework.data.repository.CrudRepository;
import dev.alexander.demo.model.Film;

public interface FilmRepository extends CrudRepository<Film, Integer> {
    
}