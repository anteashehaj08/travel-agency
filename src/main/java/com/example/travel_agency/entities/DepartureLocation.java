package com.example.travel_agency.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class DepartureLocation {
    @ManyToOne(optional = false)
    private City city;
    @ManyToOne(optional = false)
    private Airport airport;
}
