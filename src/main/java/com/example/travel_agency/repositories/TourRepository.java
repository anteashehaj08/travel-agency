package com.example.travel_agency.repositories;

import com.example.travel_agency.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour,Long>, JpaSpecificationExecutor<Tour> {
    @Query(value = "select t from Tour t where upper(t.whereFrom.airport.name) like upper(:airportName)")
    public List<Tour> findByAirport(String airportName);

    @Query(value = "select t from Tour t where upper(t.whereTo.hotel.name) like upper(:hotelName)")
    public List<Tour> findByHotel(String hotelName);

    @Query(value = "select t from Tour t where t.departureDate=:departureDate")
    public List<Tour> findByDepartureDate(String departureDate);

    @Query(value = "select t from Tour t where t.arrivalDate=:arrivalDate")
    public List<Tour> findByArrivalDate(String arrivalDate);

    @Query(value = "select t from Tour t where t.type=upper(:tourType) ")
    public List<Tour> findByTourType(String tourType);

    @Query(value = "select t from Tour t where t.whereTo.hotel.standart=:numOfStars")
    public List<Tour> findByNumOfStars(String numOfStars);

    @Query(value = "select t from Tour t where t.duration=:numOfDays")
    public List<Tour> findByNumOfDays(String numOfDays);
}
