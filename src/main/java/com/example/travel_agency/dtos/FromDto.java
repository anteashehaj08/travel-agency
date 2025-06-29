package com.example.travel_agency.dtos;

import com.example.travel_agency.entities.Airport;
import com.example.travel_agency.entities.City;
import com.example.travel_agency.entities.Hotel;
import lombok.Data;

@Data
public class FromDto {
    private Long id;
    private City city;
    private Airport airport;
}
