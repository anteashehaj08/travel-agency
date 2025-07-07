package com.example.travel_agency.service.impl;

import com.example.travel_agency.dtos.TourFilterDto;
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
import com.example.travel_agency.specifications.TourSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


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
        if (tourRepository.findById(tour.getId())!=null) {
            throw TourException.idMustBeNull();
        }
        DepartureLoc departureLoc = new DepartureLoc();
        departureLoc.setCity(cityRepository.findById(dto.getCityFromId()).orElseThrow(()->TourException.idDoesNotExist("City")));
        departureLoc.setAirport(airportRepository.findById(dto.getFromAirportId()).orElseThrow(()->TourException.idDoesNotExist("Airport")));
        tour.setWhereFrom(departureLoc);
        ArrivalLoc arrivalLoc = new ArrivalLoc();
        arrivalLoc.setCity(cityRepository.findById(dto.getCityToId()).orElseThrow(()->TourException.idDoesNotExist("City")));
        arrivalLoc.setAirport(airportRepository.findById(dto.getToAirportId()).orElseThrow(()->TourException.idDoesNotExist("Airport")));
        arrivalLoc.setHotel(hotelRepository.findById(dto.getHotelToId()).orElseThrow(()->TourException.idDoesNotExist("Hotel")));
        tour.setWhereTo(arrivalLoc);
        Long duration = ChronoUnit.DAYS.between(dto.getReturnDate(), dto.getDepartureDate());
        tour.setDuration(duration.intValue());
        return tourRepository.save(tour);
    }
    @Override
    public Tour updateTour(TourRequestDto dto) {
        Tour tour = TourRequestDto.toEntity(dto);
        if (tourRepository.findById(tour.getId()).isEmpty()) {
            throw TourException.idDoesNotExist("Tour");
        }
        if (tourRepository.findById(tour.getId())==null) {
            throw TourException.idMustNotBeNull();
        }
        DepartureLoc departureLoc = new DepartureLoc();
        departureLoc.setCity(cityRepository.findById(dto.getCityFromId()).orElseThrow(()->TourException.idDoesNotExist("City")));
        departureLoc.setAirport(airportRepository.findById(dto.getFromAirportId()).orElseThrow(()->TourException.idDoesNotExist("Airport")));
        tour.setWhereFrom(departureLoc);
        ArrivalLoc arrivalLoc = new ArrivalLoc();
        arrivalLoc.setCity(cityRepository.findById(dto.getCityToId()).orElseThrow(()->TourException.idDoesNotExist("City")));
        arrivalLoc.setAirport(airportRepository.findById(dto.getToAirportId()).orElseThrow(()->TourException.idDoesNotExist("Airport")));
        arrivalLoc.setHotel(hotelRepository.findById(dto.getHotelToId()).orElseThrow(()->TourException.idDoesNotExist("Hotel")));
        tour.setWhereTo(arrivalLoc);
        Long duration = ChronoUnit.DAYS.between(dto.getReturnDate(), dto.getDepartureDate());
        tour.setDuration(duration.intValue());
        return tourRepository.save(tour);
    }
    @Override
    public List<Tour> findAll() {
        return tourRepository.findAll()
                .stream()
                .filter(t -> t.getDepartureDate().isAfter(LocalDate.now()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Tour> filter(TourFilterDto filterDTO) {
        Specification<Tour> specification = TourSpecs.filter(filterDTO);
        return tourRepository.findAll(specification);
    }

    @Override
    public Tour findTourById(Long id) {
        return tourRepository.findById(id).orElseThrow(()->TourException.idDoesNotExist("Tour"));
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

}
