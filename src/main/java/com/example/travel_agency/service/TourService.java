package com.example.travel_agency.service;

import com.example.travel_agency.dtos.TourFilterDto;
import com.example.travel_agency.dtos.TourRequestDto;
import com.example.travel_agency.entities.Tour;


import java.util.List;

public interface TourService {
    Tour createTour(TourRequestDto dto);

    Tour updateTour(TourRequestDto dto);

    List<Tour> findAll();

    List<Tour> filter(TourFilterDto filterDTO);

    Tour findTourById(Long id);

    List<Tour> sorttedByPromoted();

    List<Tour> sorttedByDeparture();

    List<Tour> sorttedByAvailability();

/*
    void deleteByLocalDate(LocalDate date);
*/
}
