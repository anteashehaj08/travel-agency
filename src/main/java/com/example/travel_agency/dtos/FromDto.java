package com.example.travel_agency.dtos;

import com.example.travel_agency.entities.*;
import lombok.Data;

@Data
public class FromDto {
    private City city;
    private Airport airport;

    public static DepartureLoc toEntity(FromDto fromDto) {
        return DepartureLoc.builder()
                .city(fromDto.getCity())
                .airport(fromDto.getAirport())
                .build();
    }
}
