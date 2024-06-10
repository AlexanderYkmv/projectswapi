package dev.alexander.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlanetCreateRequest {

    //private Integer id;

    private String name;

    private String rotation_period;

    private String orbital_period;

    private String diameter;

    private String climate;

    private String gravity;

    private String terrain;

    private String surface_water;

    private String population;
    
}
