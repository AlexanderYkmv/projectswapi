package dev.alexander.demo.dto;

import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class PlanetResponse {
 
    private Integer id;

    private String name;

    private String rotation_period;

    private String orbital_period;

    private String diameter;

    private String climate;

    private String gravity;

    private String terrain;

    private String surface_water;

    private String population;
    
    
    private Set<String> residents;

    
    private Set<String> films;

    private String url;
    
}
