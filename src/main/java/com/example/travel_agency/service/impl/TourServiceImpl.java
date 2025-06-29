package com.example.travel_agency.service.impl;

import com.example.travel_agency.dtos.TourRequestDto;
import com.example.travel_agency.entities.ArrivalLoc;
import com.example.travel_agency.entities.DepartureLoc;
import com.example.travel_agency.entities.Tour;
import com.example.travel_agency.exceptions.TourException;
import com.example.travel_agency.repositories.AirportRepository;
import com.example.travel_agency.repositories.CityRepository;
import com.example.travel_agency.repositories.HotelRepository;
import com.example.travel_agency.repositories.TourRepository;
import com.example.travel_agency.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;

import static com.example.travel_agency.dtos.TourRequestDto.toEntity;

@Service
public class TourServiceImpl implements TourService {
    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public Tour createTour(TourRequestDto dto) {
           Tour tour = TourRequestDto.toEntity(dto);
        DepartureLoc departureLoc = new DepartureLoc();
        departureLoc.setCity(cityRepository.findById(dto.getCityFromId()).orElseThrow());
        departureLoc.setAirport(airportRepository.findById(dto.getFromAirportId()).orElseThrow());
        tour.setWhereFrom(departureLoc);
        ArrivalLoc arrivalLoc = new ArrivalLoc();
        arrivalLoc.setCity(cityRepository.findById(dto.getCityToId()).orElseThrow());
        arrivalLoc.setAirport(airportRepository.findById(dto.getToAirportId()).orElseThrow());
        arrivalLoc.setHotel(hotelRepository.findById(dto.getHotelToId()).orElseThrow());
        tour.setWhereTo(arrivalLoc);
        Long duration = ChronoUnit.DAYS.between(dto.getArrivalDate(), dto.getDepartureDate());
        tour.setDuration(duration.intValue());
        return tourRepository.save(tour);
    }
    @Override
    public Tour updateTour(Tour tour) {
        if (tourRepository.findById(tour.getId()).isEmpty()) {
            throw TourException.idDoesNotExist("Tour");
        }
        if (tourRepository.findById(tour.getId())==null) {
            throw TourException.idMustNotBeNull("Tour");
        }
        return tourRepository.save(tour);
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
