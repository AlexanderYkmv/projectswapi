package dev.alexander.demo.dto;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FilmResponse {
    
    @JsonIgnore
    private Integer id;

    private String title;

    @JsonIgnore
    private String opening_crawl;

    private String director;

    private String producer;

    private String release_date;

    private Set<String> characters;

    private Set<String> planets;
    
    private Set<String> species;

    private Set<String> vehicles;

    private Set<String> starships;

    private String created;

    private String updated;

    private String url;

}