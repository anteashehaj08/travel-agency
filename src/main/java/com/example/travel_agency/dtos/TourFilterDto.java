package com.example.travel_agency.dtos;

import com.example.travel_agency.statics.ContinentEnum;
import lombok.Data;

@Data
public class TourFilterDto {
        private ContinentEnum continentEnum;
        private Long arrivalCountryId;
        private Long arrivalCityId;
        private Long arrivalHotelId;
    }