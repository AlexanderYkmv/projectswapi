package dev.alexander.demo.dto;

import java.util.Set;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SetFilmsRequest {
   
    @NotNull
    Set<Integer> setFilms;
}
