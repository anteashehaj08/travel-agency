package com.example.travel_agency.statics;

import lombok.Data;


public enum TourType {
    BB("BED AND BREAKFAST"),
    HB("HALF BOARD"),
    FB("FULL BOARD"),
    AI("ALL INCLUSIVE");

    private final String typeDescription;

    TourType(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public String getTypeDescription() {
        return typeDescription;
    }
}
