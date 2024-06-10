package dev.alexander.demo.model;

import  java.time.LocalDateTime;
import java.util.Set;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany(mappedBy = "vehicles")
    private Set<Person> pilots;

    @ManyToMany(mappedBy = "vehicles")
    private Set<Film> films;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;
}