package com.example.travel_agency.dtos;

import com.example.travel_agency.entities.*;
import lombok.Data;

@Data
public class ToDto {
    private City city;
    private Airport airport;
    private Hotel hotel;


    public static ArrivalLoc toEntity(ToDto toDto) {
        return ArrivalLoc.builder()
                .city(toDto.getCity())
                .airport(toDto.getAirport())
                .hotel(toDto.getHotel())
                .build();
    }
}
