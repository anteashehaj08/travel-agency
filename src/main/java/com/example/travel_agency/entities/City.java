package com.example.travel_agency.entities;

import jakarta.persistence.ManyToOne;

public class City {
    private String name;
    @ManyToOne
    private Country nationality;
}
