package com.example.travel_agency.dtos;

import com.example.travel_agency.entities.Tour;
import com.example.travel_agency.statics.TourType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TourRequestDto {
    private Long id;
    private Long fromAirportId;
    private Long toAirportId;
    private Long cityFromId;
    private Long cityToId;
    private Long hotelToId;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private Integer duration;
    private TourType type;
    private Double priceForAdult;
    private Double priceForChild;
    private Boolean promoted;
    private Integer vacantPlaces;

    public static Tour toEntity(TourRequestDto tourDto) {
        return Tour.builder()
                .id(tourDto.getId())
                .departureDate(tourDto.getDepartureDate())
                .arrivalDate(tourDto.returnDate)
                .duration(tourDto.getDuration())
                .type(tourDto.getType())
                .priceForAdult(tourDto.getPriceForAdult())
                .priceForChild(tourDto.getPriceForChild())
                .numberOfPlaces(tourDto.getVacantPlaces())
                .promoted(tourDto.getPromoted())
                .build();
    }

}
