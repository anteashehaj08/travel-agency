package com.example.travel_agency.service.impl;

import com.example.travel_agency.dtos.TourRequestDto;
import com.example.travel_agency.entities.Tour;
import com.example.travel_agency.exceptions.TourException;
import com.example.travel_agency.repositories.TourRepository;
import com.example.travel_agency.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static com.example.travel_agency.dtos.TourRequestDto.toEntity;

@Service
public class TourServiceImpl implements TourService {
    @Autowired
    private TourRepository tourRepository;

    @Override
    public Tour createTour(TourRequestDto dto) {
            if (dto.getId() != null) {
                throw TourException.idMustBeNull("Tour");
            }
            Tour tour = toEntity(dto);
            return tourRepository.save(tour);
    }
    @Override
    public Tour updateTour(Tour tour) {
        if (tourRepository.findById(tour.getId()).isEmpty()) {
            throw TourException.idDoesNotExist();
        }
        if (tourRepository.findById(tour.getId())==null) {
            throw TourException.idMustNotBeNull();
        }
        return tourRepository.save(tour);/*Kontrollo id*/
    }
    @Override
    public List<Tour> findAll() {
        return tourRepository.findAll();
    }
    @Override
    public Tour findTourById(Long id) {
        return tourRepository.findById(id).get();
    }
    @Override
    public List<Tour> sorttedByPromoted(){
       return tourRepository.findAll().stream().sorted(Comparator.comparing(Tour::getPromoted).reversed()).toList();
    }
    @Override
    public List<Tour> sorttedByDeparture(){
        return tourRepository.findAll().stream().sorted(Comparator.comparing(Tour::getDepartureDate)).toList();
    }
    @Override
    public List<Tour> sorttedByAvailability(){
        return tourRepository.findAll().stream().sorted(Comparator.comparing(tour -> tour.getNumberOfPlaces()>3)).toList();
    }
    /*@Override
    public void deleteByLocalDate(LocalDate date){
        if (date.isBefore(LocalDate.now())) {
            tourRepository.deleteAll();
        }
    }
    *//* recently purchased */
}
