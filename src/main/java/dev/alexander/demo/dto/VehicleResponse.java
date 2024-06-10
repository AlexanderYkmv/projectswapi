package dev.alexander.demo.dto;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VehicleResponse {
    
    @JsonIgnore
    private Integer id;

    private String name;

    private String model;

    private String manufacturer;
    
    private String cost_in_credits;
    
    private String length;

    private String max_atmosphering_speed;

    private String crew;

    private String passengers;

    private String cargo_capacity;

    private String consumables;

    private String vehicle_class;

    private Set<String> pilots;

    private Set<String> films;

    private String created;

    private String updated;

    private String url;
}