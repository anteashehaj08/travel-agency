package com.example.travel_agency.entities;

import com.example.travel_agency.statics.ContinentEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "continents")
@Data
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ContinentEnum name;
}
