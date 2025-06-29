package com.example.travel_agency.service;

import com.example.travel_agency.entities.City;
import com.example.travel_agency.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel create(Hotel hotel);
    Hotel update(Hotel hotel);
    Hotel findById(Long Id);
    List<Hotel> findAll();
    List<Hotel> findByCity(City city);

}
