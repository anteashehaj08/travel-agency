package com.example.travel_agency.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cities")
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    @ManyToOne
    private Country nationality;
}
