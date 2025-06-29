package com.example.travel_agency.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TourRequestDto {
    private Long id;
    private FromDto whereFrom;
    private ToDto whereTo;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private Integer places;

}
