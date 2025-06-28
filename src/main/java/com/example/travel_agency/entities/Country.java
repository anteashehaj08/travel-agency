package com.example.travel_agency.entities;

import jakarta.persistence.ManyToOne;

public class Country {
    private String name;
    @ManyToOne
    private Continent continent_membership;
}
