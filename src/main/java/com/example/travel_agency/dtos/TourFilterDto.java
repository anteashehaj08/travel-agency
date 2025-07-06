package com.example.travel_agency.dtos;

import com.example.travel_agency.statics.TourType;
import lombok.Data;

@Data
public class TourFilterDto {
        private Long departureCityId;
        private Long departureAirportId;
        private Long arrivalCityId;
        private Long arrivalHotelId;
        private String departureDate;
        private String returnDate;
        private TourType type;
        private Integer hotelStars;
        private Integer duration;
    }