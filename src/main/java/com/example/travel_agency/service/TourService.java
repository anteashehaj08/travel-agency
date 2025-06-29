package com.example.travel_agency.service;

import com.example.travel_agency.dtos.TourRequestDto;
import com.example.travel_agency.entities.Tour;

import java.time.LocalDate;
import java.util.List;

public interface TourService {
    Tour createTour(Tour tour);

    Tour createTour(TourRequestDto dto);

    Tour updateTour(Tour tour);

    List<Tour> findAll();

    Tour findTourById(Long id);

    List<Tour> sorttedByPromoted();

    List<Tour> sorttedByDeparture();

    List<Tour> sorttedByAvailability();

/*
    void deleteByLocalDate(LocalDate date);
*/
}
