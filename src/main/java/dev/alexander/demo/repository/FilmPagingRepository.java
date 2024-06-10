package dev.alexander.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import dev.alexander.demo.model.Film;

public interface FilmPagingRepository extends PagingAndSortingRepository<Film, Integer> {
    
}