package com.example.travel_agency.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "airports")
@Data
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airportId;
    private String name;
    @ManyToOne
    private City city;
    @ManyToOne
    private Country countries;
}
