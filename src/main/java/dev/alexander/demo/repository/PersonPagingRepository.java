package dev.alexander.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import dev.alexander.demo.model.Person;

public interface PersonPagingRepository extends PagingAndSortingRepository<Person, Integer> {
    
}