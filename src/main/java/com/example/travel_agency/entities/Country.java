package com.example.travel_agency.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "countries")
@Data
public class Country {
    @Id
    private String name;
    @ManyToOne
    private Continent continentMembership;
}
