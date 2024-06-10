package dev.alexander.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FilmCreateRequest {

    @JsonIgnore
    private Integer id;

    @NotNull
    private String title;

    private String opening_crawl;

    private String director;

    private String producer;

    @NotNull
    private String release_date;

}
