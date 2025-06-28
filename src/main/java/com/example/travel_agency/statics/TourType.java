package com.example.travel_agency.statics;

import lombok.Data;


public enum TourType {
    BB("Bed and Breakfast"),
    HB("Half Board"),
    FB("Full Board"),
    AI("All Inclusive");

    private final String typeDescription;

    TourType(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public String getTypeDescription() {
        return typeDescription;
    }
}
