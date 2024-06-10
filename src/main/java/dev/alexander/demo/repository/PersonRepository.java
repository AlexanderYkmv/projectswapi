package dev.alexander.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.alexander.demo.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
    
}