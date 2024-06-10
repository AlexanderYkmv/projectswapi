package dev.alexander.demo.dto;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonResponse {

    @JsonIgnore
    private Integer id;

    private String name;

    private String height;

    private String mass;

    private String hair_color;

    private String eye_color;

    private String skin_color;

    private String birth_year;

    private String gender;

    private String planet;

    private Set<String> films;

    private Set<String> species;

    private Set<String> vehicles;

    private Set<String> starships;

    private String created;

    private String updated;

    private String url;
}
