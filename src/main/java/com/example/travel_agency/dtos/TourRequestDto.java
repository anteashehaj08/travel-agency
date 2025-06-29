package com.example.travel_agency.dtos;

import com.example.travel_agency.entities.Tour;
import com.example.travel_agency.statics.TourType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TourRequestDto {
    private Long id;
    private FromDto whereFrom;
    private ToDto whereTo;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private Integer duration;
    private TourType type;
    private Double priceForAdult;
    private Double priceForChild;
    private Boolean promoted;
    private Integer places;

    public static Tour toEntity(TourRequestDto tourDto) {
        return Tour.builder()
                .id(tourDto.getId())
                .whereFrom(tourDto.getWhereFrom())
                .whereTo(tourDto.getWhereTo())
                .departureDate(tourDto.getDepartureDate())
                .arrivalDate(tourDto.arrivalDate)
                .duration(tourDto.getDuration())
                .type(tourDto.getType())
                .priceForAdult(tourDto.getPriceForAdult())
                .priceForChild(tourDto.getPriceForChild())
                .numberOfPlaces(tourDto.getPlaces())
                .promoted(tourDto.getPromoted())
                .build();
    }

}
