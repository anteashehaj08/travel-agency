package com.example.travel_agency.dtos;

import com.example.travel_agency.entities.Tour;
import com.example.travel_agency.statics.TourType;
import lombok.Data;

import java.time.LocalDate;
@Data
public class TourResponseDto {
    private Long fromCityId;
    private Long toCityId;
    private Long fromAirportId;
    private Long toAirportId;
    private Long toHotelId;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private Integer duration;
    private TourType type;
    private Double priceForAdult;
    private Double priceForChild;
    private Integer vacantPlaces;

    public static TourResponseDto toDto(Tour tour) {
        TourResponseDto dto = new TourResponseDto();
        dto.setFromCityId(tour.getWhereFrom().getCity().getId());
        dto.setToCityId(tour.getWhereTo().getCity().getId());
        dto.setFromAirportId(tour.getWhereFrom().getAirport().getAirportId());
        dto.setToAirportId(tour.getWhereTo().getAirport().getAirportId());
        dto.setToHotelId(tour.getWhereTo().getHotel().getHotelId());
        dto.setDepartureDate(tour.getDepartureDate());
        dto.setReturnDate(tour.getArrivalDate());
        dto.setDuration(tour.getDuration());
        dto.setType(tour.getType());
        dto.setPriceForAdult(tour.getPriceForAdult());
        dto.setPriceForChild(tour.getPriceForChild());
        dto.setVacantPlaces(tour.getNumberOfPlaces());
        return dto;
    }
}