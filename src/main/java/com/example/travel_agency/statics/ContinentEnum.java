package com.example.travel_agency.statics;


public enum ContinentEnum {
    AFRICA("Africa"),
    ASIA("Asia"),
    EUROPE("Europe"),
    NORTH_AMERICA("North America"),
    SOUTH_AMERICA("South America"),
    AUSTRALIA("Australia"),
    ANTARCTICA("Antarctica");

    private final String displayName;

    ContinentEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
