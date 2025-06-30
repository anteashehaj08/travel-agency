package com.example.travel_agency.service;

import com.example.travel_agency.entities.City;
import com.example.travel_agency.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel create(Long CityId, String name);


    Hotel update(String name, Long hotelId, Long cityId);

    Hotel findById(Long Id);

    List<Hotel> findAll();

    List<Hotel> findByCity(Long cityId);
}
