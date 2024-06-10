package dev.alexander.demo.dto;

import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonVehiclesResponse {
    private Set<Integer> personVehicleIds;
}